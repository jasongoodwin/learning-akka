package com.akkademy

import akka.actor.Actor

class ClusterCoordinator extends Actor{
  override def receive = {

    case _ => println("unknown message")
  }
}
