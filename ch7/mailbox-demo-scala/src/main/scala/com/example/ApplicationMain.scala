package com.example

import akka.actor.ActorSystem
import akka.pattern.CircuitBreaker
import akka.pattern.ask
import akka.util.Timeout
import com.example.PingActor.PingMessage
import scala.concurrent.duration._

/**
 * Modified version of the new project from typesafe demonstrating mailbox config
 * and circuitbreaker
 */
object ApplicationMain extends App {
  val system = ActorSystem("MyActorSystem")
  implicit val ec = system.dispatcher//used by circuit breaker
  implicit val timeout = Timeout(2 seconds)//used by ask

  val pingActorWithMailbox = system.actorOf(PingActor.props.withMailbox("akka.actor.boundedmailbox"), "pingActor")
  pingActorWithMailbox ! PingActor.Initialize

  val pongActor = system.actorOf(PongActor.props, "pongactor2")

  val breaker =
    new CircuitBreaker(system.scheduler,
      maxFailures = 1,
      callTimeout = 1 seconds,
      resetTimeout = 1 seconds).
      onOpen(println("circuit breaker opened!")).
      onClose(println("circuit breaker closed!")).
      onHalfOpen(println("circuit breaker half-open"))


  val future1 = breaker.withCircuitBreaker{
    pongActor ? PingMessage("ping")
  }
  val future2 = breaker.withCircuitBreaker{
    pongActor ? PingMessage("ping")
  }

  future1.map{x => println("response1 : " + x)}
  future2.map{x => println("response2 : " + x)}//circuit breaker will half open here

  //play around with sending futures and see how the breaker responds
  Thread.sleep(1000)
  system.awaitTermination()
}