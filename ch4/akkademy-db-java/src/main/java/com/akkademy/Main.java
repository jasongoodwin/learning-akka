package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
    public static void main(String... args) {
        ActorSystem system = ActorSystem.create("akkademy");
        ActorRef actor = system.actorOf(Props.create(AkkademyDb.class), "akkademy-db");
    }
}
