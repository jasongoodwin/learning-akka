package com.akkademy

import akka.actor.Actor
import akka.event.Logging
import com.akkademy.sapi.{GetRequest, SetRequest}
import scala.collection.mutable.HashMap

class AkkademyDb extends Actor {
  val map = new HashMap[String, String]
  val log = Logging(context.system, this)

  override def receive = {
    case SetRequest(key, value) => {
      log.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)
    }
    case GetRequest(key) => {
      log.info("received GetRequest - key: {}", key)
      val response: Option[Object] = map.get(key)
      sender() ! response
    }
    case o => log.info("received unknown message: {}", o);
  }
}
