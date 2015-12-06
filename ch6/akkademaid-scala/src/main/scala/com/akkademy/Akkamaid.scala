package com.akkademy

import akka.actor.{ActorSystem, Props}
import akka.contrib.pattern.ClusterReceptionistExtension
import akka.routing.BalancingPool

object Main extends App {
  val system = ActorSystem("Akkademy")
  val clusterController = system.actorOf(Props[ClusterController], "clusterController")

  val workers = system.actorOf(BalancingPool(5).props(Props[ArticleParseActor]), "workers")

  ClusterReceptionistExtension(system).registerService(workers)
}

