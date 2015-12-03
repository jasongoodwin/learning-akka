import akka.actor.Status.Failure
import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.testkit.TestProbe
import akka.util.Timeout
import com.akkademy.messages.GetRequest
import com.akkademy.{AskDemoArticleParser, ParseArticle, ParsingActor, TellDemoArticleParser}
import org.scalatest.{FunSpec, Matchers}

import scala.concurrent.Await
import scala.concurrent.duration._

class AskAndTellDemoSpec extends FunSpec with Matchers {
  implicit val system = ActorSystem("test")
  implicit val timeout = Timeout(10 seconds)
  val cacheProbe = TestProbe()
  val httpClientProbe = TestProbe()
  val articleParseActor = system.actorOf(Props[ParsingActor])

  describe("ask demo") {
    val askDemoActor = system.actorOf(
      Props(classOf[AskDemoArticleParser],
        cacheProbe.ref.path.toString,
        httpClientProbe.ref.path.toString,
        articleParseActor.path.toString, timeout)
    )

    it("should provide parsed article") {
      val f = askDemoActor ? ParseArticle("http://www.google.com")

      //Cache gets the message first
      cacheProbe.expectMsgType[GetRequest]
      cacheProbe.reply(Failure(new Exception("no cache")))

      //if it fails, http client gets a request
      httpClientProbe.expectMsgType[String]
      httpClientProbe.reply(Articles.article1)

      val parsedArticle = Await.result(f, 10 seconds)
      println(parsedArticle)
      parsedArticle.toString should include("I’ve been writing a lot in emacs lately")
      parsedArticle.toString should not include("<body>")
    }
  }

  describe("tell demo") {
    val tellDemoActor = system.actorOf(
      Props(classOf[TellDemoArticleParser],
        cacheProbe.ref.path.toString,
        httpClientProbe.ref.path.toString,
        articleParseActor.path.toString,
        timeout)
    )

    it("should provide parsed article") {
      val f = tellDemoActor ? ParseArticle("http://www.google.com")

      //Cache gets the message first
      cacheProbe.expectMsgType[GetRequest]
      cacheProbe.reply(Failure(new Exception("no cache")))

      //if it fails, http client gets a request
      httpClientProbe.expectMsgType[String]
      httpClientProbe.reply(Articles.article1)

      val parsedArticle = Await.result(f, 10 seconds)
      println(parsedArticle)
      parsedArticle.toString should include("I’ve been writing a lot in emacs lately")
      parsedArticle.toString should not include("<body>")
    }

  }

}
