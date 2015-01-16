package com.akkademy

import akka.util.Timeout
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}
import akka.actor.ActorSystem
import com.akkademy.sapi.{GetRequest, SetRequest}
import scala.util.Success
import akka.testkit.{TestActorRef}
import akka.pattern.ask
import scala.concurrent.duration._

class AkkademyDbSpec extends FunSpecLike with Matchers with BeforeAndAfterEach {
  implicit val system = ActorSystem()
  implicit val timeout = Timeout(5 seconds)

  describe("akkademyDb") {
    describe("given SetRequest"){
      it("should place key/value into map"){
        val actorRef = TestActorRef(new AkkademyDb)
        actorRef ! SetRequest("key", "value")

        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("key") should equal(Some("value"))
      }
    }

    describe("given GetRequest"){
      it("should get value from map given SetRequest message"){
        val actorRef = TestActorRef(new AkkademyDb)
        actorRef ! SetRequest("key", "value")

        val future = actorRef ? GetRequest("key")
        val Success(Some(result: String)) = future.value.get
        result should equal("value")
      }
    }
  }
}

