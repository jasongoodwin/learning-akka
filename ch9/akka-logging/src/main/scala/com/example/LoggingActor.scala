package com.example

import akka.actor.{Actor, ActorLogging, Props}

class LoggingActor extends Actor with ActorLogging {
  
  var counter = 0
  val pongActor = context.actorOf(PongActor.props, "pongActor")

  def receive = {
  	case x =>
  	  log.info("LoggingActor received event: {}", x.toString)
  }	
}

object LoggingActor {
  val props = Props[LoggingActor]
  case object Initialize
  case class PingMessage(text: String)
}