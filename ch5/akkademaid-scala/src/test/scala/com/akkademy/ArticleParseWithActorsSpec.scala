package com.akkademy

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.routing.RoundRobinPool
import com.akkademy.TestHelper.TestCameoActor
import org.scalatest.{FlatSpec, Matchers}

import scala.concurrent.duration._
import scala.concurrent.{Await, Future, Promise}

class ArticleParseWithActorsSpec extends FlatSpec with Matchers {
  val system = ActorSystem()

  val workerRouter: ActorRef =
    system.actorOf(
      Props.create(classOf[ArticleParseActor]).
        withDispatcher("my-dispatcher").
        withRouter(new RoundRobinPool(8)), "workerRouter")
  val future: Future[Int] = Future{
    1
  }(system.dispatcher)

  "ArticleParseActor" should "do work concurrently" in {

    val p = Promise[String]()

    val cameoActor: ActorRef =
    system.actorOf(Props(new TestCameoActor(p)))

    (0 to 2000).foreach(x => {
      workerRouter.tell(
        new ParseArticle(TestHelper.file)
        , cameoActor);
    })

    TestHelper.profile(() => Await.ready(p.future, 20 seconds), "Actors")
  }
}




