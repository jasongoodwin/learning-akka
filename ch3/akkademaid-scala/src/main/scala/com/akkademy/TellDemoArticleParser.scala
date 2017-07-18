package com.akkademy

import java.util.concurrent.TimeoutException

import akka.actor.Status.Failure
import akka.actor.{Actor, ActorRef, Props}
import akka.util.Timeout
import com.akkademy.messages.{GetRequest, SetRequest}

class TellDemoArticleParser(cacheActorPath: String,
                            httpClientActorPath: String,
                            articleParserActorPath: String,
                            implicit val timeout: Timeout
                             ) extends Actor {
  val cacheActor = context.actorSelection(cacheActorPath)
  val httpClientActor = context.actorSelection(httpClientActorPath)
  val articleParserActor = context.actorSelection(articleParserActorPath)

  implicit val ec = context.dispatcher

  /**
   * While this example is a bit harder to understand than the ask demo,
   * for extremely performance critical applications, this has an advantage over ask.
   * The creation of 5 objects are saved - only one extra actor is created.
   * Functionally it's similar.
   * It will make the request to the HTTP actor w/o waiting for the cache response though (can be solved).
   * @return
   */

  override def receive: Receive = {
    case ParseArticle(uri) =>

      val extraActor = buildExtraActor(sender(), uri)

      cacheActor.tell(GetRequest(uri), extraActor)
      httpClientActor.tell(uri, extraActor)

      context.system.scheduler.scheduleOnce(timeout.duration, extraActor, "timeout")
  }

  /**
   * The extra actor will collect responses from the assorted actors it interacts with.
   * The cache actor reply, the http actor reply, and the article parser reply are all handled.
   * Then the actor will shut itself down once the work is complete.
   * A great use case for the use of tell here (aka extra pattern) is aggregating data from several sources.
   */
  private def buildExtraActor(senderRef: ActorRef, uri: String): ActorRef = {
    return context.actorOf(Props(new Actor{
      override def receive = {
        case "timeout" => //if we get timeout, then fail
          senderRef ! Failure(new TimeoutException("timeout!"))
          context.stop(self)

        case HttpResponse(body) => //If we get the http response first, we pass it to be parsed.
          articleParserActor ! ParseHtmlArticle(uri, body)

        case body: String => //If we get the cache response first, then we handle it and shut down.
          //The cache response will come back before the HTTP response so we never parse in this case.
          senderRef ! body
          context.stop(self)

        case ArticleBody(uri, body) => //If we get the parsed article back, then we've just parsed it
          cacheActor ! SetRequest(uri, body) //Cache it as we just parsed it
          senderRef ! body
          context.stop(self)

        case t => //We can get a cache miss
          println("ignoring msg: " + t.getClass)
      }
    }))
  }

}
