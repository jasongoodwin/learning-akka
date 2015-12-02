package com.example;

import akka.actor.ActorRef;
import akka.event.japi.LookupEventBus;

public class JavaLookupClassifier extends LookupEventBus<EventBusMessage, ActorRef, String> {

    // is used for extracting the classifier from the incoming events
    @Override public String classify(EventBusMessage event) {
        return event.topic;
    }


    @Override public void publish(EventBusMessage event, ActorRef subscriber) {
        subscriber.tell(event.msg, ActorRef.noSender());
    }

    @Override public int compareSubscribers(ActorRef a, ActorRef b) {
        return a.compareTo(b);
    }

    // determines the initial size of the index data structure
    @Override public int mapSize() {
        return 128;
    }
}