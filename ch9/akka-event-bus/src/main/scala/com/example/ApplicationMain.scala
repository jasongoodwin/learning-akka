package com.example

import akka.actor.{Actor, ActorSystem, Props}

object ApplicationMain extends App {
  val system = ActorSystem("MyActorSystem")
  val greetingActor = system.actorOf(Props(new GreetingActor))

  val lookupBus = new JavaLookupClassifier
  lookupBus.subscribe(greetingActor, "greetings")
  lookupBus.publish(new EventBusMessage("time", System.currentTimeMillis().toString))
  lookupBus.publish(new EventBusMessage("greetings", "hello"))
}

class GreetingActor extends Actor {
  override def receive: Receive = {
    case x => println("guess we received a greeting! msg: " + x)
  }
}