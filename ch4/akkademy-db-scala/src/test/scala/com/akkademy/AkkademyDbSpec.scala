package com.akkademy

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.akkademy.messages.SetRequest
import com.typesafe.config.ConfigFactory
import org.scalatest.{FunSpecLike, Matchers}

class AkkademyDbSpec extends FunSpecLike with Matchers {
  implicit val system = ActorSystem("system", ConfigFactory.empty) //ignore config for remoting
//  implicit val timeout = Timeout(5 seconds)

  describe("akkademyDb") {
    describe("given SetRequest"){
      it("should place key/value into map"){
        val actorRef = TestActorRef(new AkkademyDb)
          actorRef ! SetRequest("key", "value")

        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("key") should equal(Some("value"))
      }
    }

    describe("given List[SetRequest]"){
      it("should place key/values into map"){
        val actorRef = TestActorRef(new AkkademyDb)
        actorRef ! List(SetRequest("key", "value"), SetRequest("key2", "value2"))

        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("key") should equal(Some("value"))
        akkademyDb.map.get("key2") should equal(Some("value2"))
      }
    }
  }
}

