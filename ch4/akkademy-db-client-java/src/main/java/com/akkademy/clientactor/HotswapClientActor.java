package com.akkademy.clientactor;

import akka.actor.AbstractActorWithStash;
import akka.actor.ActorSelection;
import akka.japi.pf.ReceiveBuilder;
import com.akkademy.messages.Connected;
import com.akkademy.messages.Request;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

/**
 * Use mailbox with stash-capacity
 * or build some sort of timeout to avoid memory leak.
 */

public class HotswapClientActor extends AbstractActorWithStash {
    private ActorSelection remoteDb;

    private PartialFunction<Object, BoxedUnit> disconnected;
    private PartialFunction<Object, BoxedUnit> online;

    public HotswapClientActor(String dbPath) {
        remoteDb = context().actorSelection(dbPath);

        disconnected = ReceiveBuilder.
                match(Request.class, x -> { //can't handle until we know remote system is responding
                    remoteDb.tell(new Connected(), self()); //see if the remote actor is up
                    stash(); //stash message for later
                }).
                match(Connected.class, x -> { // Okay to start processing messages.
                    context().become(online);
                    unstash();
                }).build();

        online = ReceiveBuilder.
                        match(Request.class, x -> {
                            remoteDb.forward(x, context()); //forward instead of tell to preserve sender
                        }).
                        build();

        receive(disconnected); //initial state.
    }
}

 /**
 * Disconnect msg is unimplemented in this example.
 * Because we're not dealing w/ sockets directly,
 * we could instead implement an occasional ping/heartbeat that restarts
 * this Actor if the remote actor isn't responding.
 * After restarting, the actor will revert to the
 * default state and stash messages
 */

class Disconnected {
}
