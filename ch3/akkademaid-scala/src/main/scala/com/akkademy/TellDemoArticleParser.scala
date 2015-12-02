package com.akkademy

import java.util.concurrent.TimeoutException

import akka.actor.Status.Failure
import akka.actor.{Actor, ActorRef, Props}
import akka.util.Timeout
import com.akkademy.messages.SetRequest
import scala.concurrent.duration._

class TellDemoArticleParser(cacheActorPath: String,
                            httpClientActorPath: String,
                            acticleParserActorPath: String,
                            implicit val timeout: Timeout
                             ) extends Actor {
  val cacheActor = context.actorSelection(cacheActorPath)
  val httpClientActor = context.actorSelection(cacheActorPath)
  val articleParserActor = context.actorSelection(cacheActorPath)

  override def receive: Receive = {
    case msg @ ParseArticle(uri) =>

      val extraActor = buildExtraActor(sender())
      cacheActor.tell(msg, extraActor)
      httpClientActor.tell(msg, extraActor)
      context.system.scheduler.scheduleOnce(2 seconds, extraActor, "timeout")
  }

  private def buildExtraActor(senderRef: ActorRef): ActorRef = {
    return context.actorOf(Props(new Actor{
      override def receive = {
        case "timeout" =>
          senderRef ! Failure(new TimeoutException("timeout!"))
          context.stop(self)
        case article: String =>
          senderRef ! article
          context.stop(self)
        case HttpResponse(body) =>
          articleParserActor ! body
        case x @ ArticleBody(uri, body) =>
          cacheActor ! SetRequest(uri, body)
          senderRef ! x
          context.stop(self)
      }
    }))
  }

}
