package com.akkademy

import akka.actor.{Status, Props, ActorSystem}
import akka.testkit.{TestProbe, TestActorRef}
import akka.util.Timeout
import com.akkademy.messages.SetRequest
import com.typesafe.config.ConfigFactory
import org.scalatest.{FunSpecLike, Matchers}
import scala.concurrent.duration._
import scala.language.postfixOps
import com.akkademy.clientactor._

class FsmClientActorSpec extends FunSpecLike with Matchers {
  implicit val system = ActorSystem("test-system", ConfigFactory.defaultReference())
  implicit val timeout = Timeout(5 seconds)

  val dbRef = TestActorRef[AkkademyDb](Props(classOf[AkkademyDb]), "db")
  val db = dbRef.underlyingActor
  val testProbe = TestProbe()

  describe("FsmClientActor") {
    val fsmClientRef = TestActorRef[FSMClientActor](Props(classOf[FSMClientActor], dbRef.path.toString), "fsm")
    val fsmClient = fsmClientRef.underlyingActor
      it("should transition from Disconnected to ConnectedAndPending when getting a msg"){
        fsmClient.stateName should equal (Disconnected)
        fsmClientRef ! SetRequest("key", "value", testProbe.ref)
        fsmClient.stateName should equal (ConnectedAndPending)
        db.map.get("key") should equal(None)
      }

    it("should transition from ConnectedAndPending to Connected when flushing"){
      fsmClient.stateName should equal (ConnectedAndPending)
      fsmClientRef ! Flush
      fsmClient.stateName should equal (Connected)
      db.map.get("key") should equal(Some("value"))
      testProbe.expectMsg(Status.Success)
    }
  }
}


