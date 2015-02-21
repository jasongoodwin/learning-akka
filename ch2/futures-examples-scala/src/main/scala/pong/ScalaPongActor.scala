package pong

import akka.actor.{Actor, Status}

class ScalaPongActor extends Actor {
  self
  override def receive: Receive = {
    case "Ping" => sender() ! "Pong"
    case _ => sender() ! Status.Failure(new Exception("unknown message"))
  }
}
