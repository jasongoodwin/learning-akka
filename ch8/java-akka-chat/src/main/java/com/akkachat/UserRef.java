package com.akkachat;

import akka.actor.ActorRef;

public class UserRef {
    public final ActorRef actor;
    public final String username;

    public UserRef(ActorRef actor, String username) {
        this.actor = actor;
        this.username = username;
    }
}
