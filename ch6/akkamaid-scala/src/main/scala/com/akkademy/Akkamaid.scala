package com.akkademy

import akka.actor.{ActorRef, Props, ActorSystem}
import akka.contrib.pattern.ClusterReceptionistExtension
import akka.routing.BalancingPool

object Main extends App {
  val system = ActorSystem("Akkademy")
  val clusterController = system.actorOf(Props[ClusterController], "clusterController")

  val workers =
    system.actorOf(BalancingPool(5).props(Props[ArticleParseActor]), "router10")

  ClusterReceptionistExtension(system).registerService(workers)
}

