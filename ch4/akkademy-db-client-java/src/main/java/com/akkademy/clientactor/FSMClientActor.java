package com.akkademy.clientactor;

import akka.actor.AbstractFSM;
import akka.actor.ActorSelection;
import com.akkademy.messages.Connected;
import com.akkademy.messages.Request;

import java.util.LinkedList;

import static com.akkademy.clientactor.State.*;

enum State{
    DISCONNECTED,
    CONNECTED,
    CONNECTED_AND_PENDING
}

class EventQueue extends LinkedList<Request> {}
class FlushMsg{}

/**
 * To revert to disconnected, we could send occassional heartbeat pings
 * and revert by restarting the actor (throwing an exception)
 */

public class FSMClientActor extends AbstractFSM<State, EventQueue>{

    private ActorSelection remoteDb;

    public FSMClientActor(String dbPath){
        remoteDb = context().actorSelection(dbPath);
    }

    {
        startWith(DISCONNECTED, new EventQueue());

        when(DISCONNECTED,
                matchEvent(FlushMsg.class, (msg, container) -> stay())
                        .event(Request.class, (msg, container) -> {
                            remoteDb.tell(new Connected(), self());
                            container.add(msg);
                            return stay();
                        }).event(Connected.class, (msg, container) -> {
                    if(container.size() == 0){
                        return goTo(CONNECTED);
                    }else{
                        return goTo(CONNECTED_AND_PENDING);
                    }
                }));

        when(CONNECTED,
                matchEvent(FlushMsg.class, (msg, container) ->
                        stay()
                )
                        .event(Request.class, (msg, container) -> {
                            container.add(msg);
                            return goTo(CONNECTED_AND_PENDING);
                        }));


        when(CONNECTED_AND_PENDING,
                matchEvent(FlushMsg.class, (msg, container) -> {
                    remoteDb.tell(container, self());
                    container = new EventQueue();
                    return goTo(CONNECTED);
                })
                        .event(Request.class, (msg, container) -> {
                            container.add(msg);
                            return goTo(CONNECTED_AND_PENDING);
                        }));

        initialize();
    }
}