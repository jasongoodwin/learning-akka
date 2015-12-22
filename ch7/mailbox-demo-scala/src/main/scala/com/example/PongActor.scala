package com.example

import akka.actor.{Actor, ActorLogging, Props}

class PongActor extends Actor with ActorLogging {
  import PongActor._

  def receive = {
  	case PingActor.PingMessage(text) =>
      Thread.sleep(700)
  	  log.info("In PongActor - received message: {}", text)
  	  sender() ! PongMessage("pong")
  }	
}

object PongActor {
  val props = Props[PongActor]
  case class PongMessage(text: String)
}
