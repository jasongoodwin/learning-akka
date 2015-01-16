package com.akkademy

import akka.actor.Actor
import akka.event.Logging
import com.akkademy.sapi.SetRequest
import scala.collection.mutable.HashMap

class AkkademyDb extends Actor {
  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive = {
    case message: SetRequest => {
      log.info("Received Set request: {}", message)
      map.put(message.key, message.value)
    }
    case o => log.info("received unknown message: {}", o);
  }
}
