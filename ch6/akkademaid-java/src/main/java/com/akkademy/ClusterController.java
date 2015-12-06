package com.akkademy;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.cluster.Cluster;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.List;

import static akka.cluster.ClusterEvent.*   ;

public class ClusterController extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    Cluster cluster = Cluster.get(getContext().system());

    List<ActorRef> workers = new ArrayList<>();

    @Override
    public void preStart() {
        cluster.subscribe(self(), initialStateAsEvents(),
                MemberEvent.class, UnreachableMember.class);
    }

    @Override
    public void postStop() {
        cluster.unsubscribe(self());
    }

    private ClusterController(){
        receive(ReceiveBuilder.
                        match(MemberEvent.class, message -> {
                            if(message.getClass() == MemberUp.class){
                                System.out.println("member up: " + message.member().address());
                            }
                            log.info("MemberEvent: {}", message);
                        }).
                        match(UnreachableMember.class, message -> {
                            log.info("UnreachableMember: {}", message);
                        }).build()
        );
    }
}