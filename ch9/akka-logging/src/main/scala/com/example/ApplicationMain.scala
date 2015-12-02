package com.example

import akka.actor.ActorSystem

object ApplicationMain extends App {
  val system = ActorSystem("MyActorSystem")
  val pingActor = system.actorOf(LoggingActor.props, "pingActor")
  pingActor ! "message1"
  pingActor ! "message2"
  pingActor ! "message3"
  system.shutdown()
}