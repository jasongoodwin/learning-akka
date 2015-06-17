package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
    public static void main(String... args) {
        ActorSystem system = ActorSystem.create("Akkademy");
        ActorRef clusterController = system.actorOf(Props.create(ClusterController.class), "clusterController");
    }
}
