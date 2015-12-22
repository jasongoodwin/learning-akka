package com.example;

import akka.actor.UntypedActor;
import akka.actor.Props;
import akka.japi.Creator;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class PongActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public static Props props() {
        return Props.create(PongActor.class);
    }

    public static class PongMessage {
        private final String text;

        public PongMessage(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    public void onReceive(Object message) throws Exception {
        if (message instanceof PingActor.PingMessage) {
            Thread.sleep(1000);
            PingActor.PingMessage ping = (PingActor.PingMessage) message;
            log.info("In PongActor - received message: {}", ping.getText());
            getSender().tell(new PongMessage("pong"), getSelf());
        } else {
            unhandled(message);
        }
    }
}