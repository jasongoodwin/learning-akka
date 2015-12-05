package com.akkademy

import akka.actor.{Status, ActorSystem, Props}
import akka.testkit.{TestActorRef, TestProbe}
import akka.util.Timeout
import com.akkademy.messages.{GetRequest, SetRequest}
import com.typesafe.config.ConfigFactory
import org.scalatest.{FunSpec, Matchers}

import scala.concurrent.duration._

class HotswapClientActorSpec extends FunSpec with Matchers {
  implicit val system = ActorSystem("test-system", ConfigFactory.defaultReference())
  implicit val timeout = Timeout(5 seconds)

  describe("HotswapClientActor"){
    it("should set values"){
      val dbRef = TestActorRef[AkkademyDb]
      val db = dbRef.underlyingActor
      val probe = TestProbe()
      val clientRef = TestActorRef(Props.create(classOf[HotswapClientActor], dbRef.path.toString))

      clientRef ! new SetRequest("testkey", "testvalue", probe.ref)
      probe.expectMsg(Status.Success)
      db.map.get("testkey") should equal(Some("testvalue"))
    }

    it("should get values"){
      val dbRef = TestActorRef[AkkademyDb]
      val db = dbRef.underlyingActor
      db.map.put("testkey", "testvalue")

      val probe = TestProbe()
      val clientRef = TestActorRef(Props.create(classOf[HotswapClientActor], dbRef.path.toString))

      clientRef ! new GetRequest("testkey", probe.ref)
      probe.expectMsg("testvalue")
    }
  }


}