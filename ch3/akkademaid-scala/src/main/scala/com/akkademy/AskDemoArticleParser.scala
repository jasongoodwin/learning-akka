package com.akkademy

import akka.actor.Actor
import akka.pattern.ask
import akka.util.Timeout
import com.akkademy.messages.{SetRequest, GetRequest}

class AskDemoArticleParser(cacheActorPath: String,
                           httpClientActorPath: String,
                           acticleParserActorPath: String,
                           implicit val timeout: Timeout
                            ) extends Actor {
  val cacheActor = context.actorSelection(cacheActorPath)
  val httpClientActor = context.actorSelection(httpClientActorPath)
  val articleParserActor = context.actorSelection(acticleParserActorPath)
  import scala.concurrent.ExecutionContext.Implicits.global

  override def receive: Receive = {
    case ParseArticle(uri) =>
      val senderRef = sender() //sender ref needed for use in callback (see Pipe pattern for better solution)

      val cacheResult = cacheActor ? GetRequest(uri) //ask cache actor

      val result = cacheResult.recoverWith { //if request fails, then ask the articleParseActor
        case _: Exception =>
          val fRawResult = httpClientActor ? uri

          fRawResult flatMap {rawArticle =>
            articleParserActor ? rawArticle
          }
      }

      // take the result and pipe it back to the actor
      // (see Pipe pattern for improved implementation)
      result.mapTo[String] onComplete {
        case scala.util.Success(x) =>
          cacheActor ! SetRequest(uri, x)
          senderRef ! x
        case scala.util.Failure(t) =>
          senderRef ! akka.actor.Status.Failure(t)
        case x =>
          println("unknown message! " + x)
      }
  }
}
