package com.akkademy

import java.util.Date

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.akkademy.sapi.SetRequest
import org.scalatest.{FunSpecLike, Matchers}

class AkkademyDbSpec extends FunSpecLike with Matchers {
  implicit val system = ActorSystem()

  describe("akkademyDb") {
    it("should place key/value from Set message into map"){
      val actorRef = TestActorRef(new AkkademyDb)

      actorRef ! SetRequest("key", "value")

      val akkademyDb = actorRef.underlyingActor
      akkademyDb.map.get("key") should equal(Some("value"))
    }
  }
}

