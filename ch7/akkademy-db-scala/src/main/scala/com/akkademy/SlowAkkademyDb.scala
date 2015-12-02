package com.akkademy

import akka.actor._
import akka.event.Logging
import akka.pattern.{CircuitBreaker, ask}
import akka.util.Timeout
import com.akkademy.sapi.{GetRequest, KeyNotFoundException, SetRequest}

import scala.collection.mutable.HashMap
import scala.concurrent.Await
import scala.concurrent.duration._

class FastSlowAkkademyDb extends Actor {
  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)
  
  override def receive = {
    case SetRequest(key, value) =>
      log.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)
      sender() ! Status.Success
    case GetRequest(key) =>
      Thread.sleep(70)
      val response: Option[Object] = map.get(key)
      response match {
        case Some(x) => sender() ! x
        case None => sender() ! Status.Failure(new KeyNotFoundException(key))
      }
    case o => Status.Failure(new ClassNotFoundException)
  }
}

object Main extends App {
  val system = ActorSystem("Akkademy")
  implicit val ec = system.dispatcher

  val breaker =
    new CircuitBreaker(system.scheduler,
      maxFailures = 10,
      callTimeout = 1 seconds,
      resetTimeout = 1 seconds).
      onOpen(println("circuit breaker opened!")).
      onClose(println("circuit breaker closed!")).
      onHalfOpen(println("circuit breaker half-open"))

  implicit val timeout = Timeout(2 seconds)
  val db = system.actorOf(Props[FastSlowAkkademyDb])
  Await.result(db ? SetRequest("key", "value"), 2 seconds)

  (1 to 1000000).map(x => {
    Thread.sleep(50)
    val askFuture = breaker.withCircuitBreaker(db ? GetRequest("key"))
    askFuture.map(x => "got it: " + x).recover({
      case t => "error: " + t.toString
    }).foreach(x => println(x))
  })
}