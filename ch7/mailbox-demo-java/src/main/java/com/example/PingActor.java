package com.example;

import akka.actor.UntypedActor;
import akka.actor.Props;
import akka.actor.ActorRef;
import akka.japi.Creator;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class PingActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public static Props props() {
        return Props.create(PingActor.class);
    }

    public static class Initialize {
    }

    public static class PingMessage {
        private final String text;

        public PingMessage(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    private int counter = 0;
    private ActorRef pongActor = getContext().actorOf(PongActor.props(), "pongActor");

    public void onReceive(Object message) throws Exception {
        if (message instanceof Initialize) {
            log.info("In PingActor - starting ping-pong");
            pongActor.tell(new PingMessage("ping"), getSelf());
        } else if (message instanceof PongActor.PongMessage) {
            PongActor.PongMessage pong = (PongActor.PongMessage) message;
            log.info("In PingActor - received message: {}", pong.getText());
            counter += 1;
            if (counter == 3) {
                getContext().system().shutdown();
            } else {
                getSender().tell(new PingMessage("ping"), getSelf());
            }
        } else {
            unhandled(message);
        }
    }
}