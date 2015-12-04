import akka.actor.Status.Failure
import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.testkit.TestProbe
import akka.util.Timeout
import com.akkademy.messages.{GetRequest, SetRequest}
import com.akkademy._
import org.scalatest.{FunSpec, Matchers}

import scala.concurrent.Await
import scala.concurrent.duration._

class AskAndTellDemoSpec extends FunSpec with Matchers {
  implicit val system = ActorSystem("test")
  implicit val timeout = Timeout(10 seconds)

  describe("ask demo") {
    val cacheProbe = TestProbe()
    val httpClientProbe = TestProbe()
    val articleParseActor = system.actorOf(Props[ParsingActor])
    val askDemoActor = system.actorOf(
      Props(classOf[AskDemoArticleParser],
        cacheProbe.ref.path.toString,
        httpClientProbe.ref.path.toString,
        articleParseActor.path.toString,
        timeout)
    )

    it("should provide parsed article") {
      val f = askDemoActor ? ParseArticle("http://www.google.com")

      //Cache gets the message first. Fail cache request.
      cacheProbe.expectMsgType[GetRequest]
      cacheProbe.reply(Failure(new Exception("no cache")))

      //if it fails, http client gets a request
      httpClientProbe.expectMsgType[String]
      httpClientProbe.reply(HttpResponse(Articles.article1))

      cacheProbe.expectMsgType[SetRequest] //Article will be cached.

      val parsedArticle = Await.result(f, 10 seconds)
      parsedArticle.toString should include("I’ve been writing a lot in emacs lately")
      parsedArticle.toString should not include("<body>")
    }

    it("should provide cached article") {
      val f = askDemoActor ? ParseArticle("http://www.google.com")

      //Cache gets the message first. Fail cache request.
      cacheProbe.expectMsgType[GetRequest]
      cacheProbe.reply(de.l3s.boilerpipe.extractors.ArticleExtractor.INSTANCE.getText(Articles.article1))

      val parsedArticle = Await.result(f, 10 seconds)
      parsedArticle.toString should include("I’ve been writing a lot in emacs lately")
      parsedArticle.toString should not include("<body>")
    }
  }

  describe("tell demo") {
    val cacheProbe = TestProbe()
    val httpClientProbe = TestProbe()
    val articleParseActor = system.actorOf(Props[ParsingActor])
    val tellDemoActor = system.actorOf(
      Props(classOf[TellDemoArticleParser],
        cacheProbe.ref.path.toString,
        httpClientProbe.ref.path.toString,
        articleParseActor.path.toString,
        timeout)
    )
    it("should provide parsed article") {
      val f = tellDemoActor ? ParseArticle("http://www.google.com")

      //Cache gets the message first. Fail cache request.
      cacheProbe.expectMsgType[GetRequest]
      cacheProbe.reply(Failure(new Exception("no cache")))

      //if it fails, http client gets a request
      httpClientProbe.expectMsgType[String]
      httpClientProbe.reply(HttpResponse(Articles.article1))

      cacheProbe.expectMsgType[SetRequest] //Article will be cached.

      val parsedArticle = Await.result(f, 10 seconds)
      parsedArticle.toString should include("I’ve been writing a lot in emacs lately")
      parsedArticle.toString should not include("<body>")
    }

    it("should provide cached article") {
      val f = tellDemoActor ? ParseArticle("http://www.google.com")

      //Cache gets the message first. Fail cache request.
      cacheProbe.expectMsgType[GetRequest]
      cacheProbe.reply(de.l3s.boilerpipe.extractors.ArticleExtractor.INSTANCE.getText(Articles.article1)
      )

      val parsedArticle = Await.result(f, 10 seconds)
      parsedArticle.toString should include("I’ve been writing a lot in emacs lately")
      parsedArticle.toString should not include("<body>")
    }
  }

}
