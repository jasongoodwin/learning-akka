package com.akkademy.clientactor;

import akka.actor.AbstractFSM;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.io.Tcp;
import akka.japi.pf.FSMStateFunctionBuilder;
import akka.japi.pf.ReceiveBuilder;
import com.akkademy.japi.GetRequest;
import com.akkademy.japi.SetRequest;
import static com.akkademy.clientactor.State.*;
import java.util.LinkedList;

enum State{
    DISCONNECTED,
    CONNECTED,
    CONNECTED_AND_PENDING
}

class EventQueue extends LinkedList<GetRequest> {}
class ConnectedMsg{}
class FlushMsg{}

public class FSMClientActor extends AbstractFSM<State, EventQueue>{

    private ActorSelection remoteDb;

    public FSMClientActor(String remoteAddress){
        remoteDb = context().actorSelection("akka.tcp://akkademy@" + remoteAddress + "/user/akkademy-db");
    }

    {
        startWith(DISCONNECTED, null);

        when(DISCONNECTED,
                matchEvent(FlushMsg.class, (msg, container) -> stay())
                        .event(GetRequest.class, (msg, container) -> {
                            container.add(msg);
                            return stay();
                        }).event(Tcp.Connected.class, (msg, container) -> {
                    if(container.getFirst() == null){
                        return goTo(CONNECTED);
                    }else{
                        return goTo(CONNECTED_AND_PENDING);
                    }
                }));

        when(CONNECTED,
                matchEvent(FlushMsg.class, (msg, container) -> stay())
                        .event(GetRequest.class, (msg, container) -> {
                            container.add(msg);
                            return goTo(CONNECTED_AND_PENDING);
                        }));


        when(CONNECTED_AND_PENDING,
                matchEvent(FlushMsg.class, (msg, container) -> {
                    container = new EventQueue();
                    return stay();
                })
                        .event(GetRequest.class, (msg, container) -> {
                            container.add(msg);
                            return goTo(CONNECTED_AND_PENDING);
                        }));

        initialize();
    }
}