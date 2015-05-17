package com.akkademy.askdemo

import akka.actor.Actor
import akka.pattern.ask
import akka.util.Timeout
import com.akkademy.sapi.{SetRequest, GetRequest}

class AskDemoArticleParser(cacheActorPath: String,
                           httpClientActorPath: String,
                           acticleParserActorPath: String,
                           implicit val timeout: Timeout
                            ) extends Actor {
  val cacheActor = context.actorSelection(cacheActorPath)
  val httpClientActor = context.actorSelection(cacheActorPath)
  val articleParserActor = context.actorSelection(cacheActorPath)
  import scala.concurrent.ExecutionContext.Implicits.global

  override def receive: Receive = {
    case ParseArticle(uri) =>
      val senderRef = sender() //sender ref needed!!

      val cacheResult = cacheActor ? GetRequest(uri)

      val result = cacheResult.recoverWith {
        case _: Exception =>
          val fRawResult = httpClientActor ? uri
          fRawResult flatMap (rawArticle =>
            articleParserActor ? rawArticle)
      }

      result.mapTo[String] onComplete {
        case scala.util.Success(x) =>
          cacheActor ! SetRequest(uri, x)
          senderRef ! x
        case scala.util.Failure(t) =>
          senderRef ! akka.actor.Status.Failure(t)
      }
  }
}
