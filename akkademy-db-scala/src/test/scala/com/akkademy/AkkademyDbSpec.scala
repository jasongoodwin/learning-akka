package com.akkademy

import akka.util.Timeout
import com.akkademy.AkkademyDb
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}
import akka.actor.{Props, ActorSystem}
import com.akkademy.sapi.SetRequest
import akka.testkit.TestActorRef
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
  }
}

