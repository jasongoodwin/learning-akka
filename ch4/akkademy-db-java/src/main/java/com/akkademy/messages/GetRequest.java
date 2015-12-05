package com.akkademy.messages;

import akka.actor.ActorRef;

import java.io.Serializable;

public class GetRequest implements Serializable, Request {
    public final String key;
    public final ActorRef sender;

    public GetRequest(String key, ActorRef sender) {
        this.key = key;
        this.sender = sender;
    }

    public GetRequest(String key) {
        this.key = key;
        this.sender = ActorRef.noSender();
    }

    @Override
    public String toString() {
        return "GetRequest{" +
                "key='" + key + '\'' +
                ", sender=" + sender +
                '}';
    }
}
