package com.akkademy.messages;

import akka.actor.ActorRef;

import java.io.Serializable;

public class SetRequest implements Serializable, Request {
    public final String key;
    public final Object value;
    public final ActorRef sender;

    public SetRequest(String key, Object value, ActorRef sender) {
        this.key = key;
        this.value = value;
        this.sender = sender;
    }

    public SetRequest(String key, Object value) {
        this.key = key;
        this.value = value;
        this.sender = ActorRef.noSender();
    }

    @Override
    public String toString() {
        return "SetRequest{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", sender=" + sender +
                '}';
    }
}
