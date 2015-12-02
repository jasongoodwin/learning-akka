package com.akkachat

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestActorRef, TestKit, TestProbe}
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.duration._

class ChatroomSpec(_system: ActorSystem) extends TestKit(_system)
  with ImplicitSender
  with FunSpecLike with Matchers {

  describe("Given a Chatroom has no users"){
    val props: Props = Props.create(classOf[Chatroom])
    val ref: TestActorRef[Chatroom] = TestActorRef.create(system, props, "testA")
    val chatroom: Chatroom = ref.underlyingActor
    chatroom.joinedUsers.size should equal(0)

    describe("when it receives a request from a user to join the chatroom"){
      val userRef: UserRef = new UserRef(system.deadLetters, "user")
      val request: JoinChatroom = JoinChatroom(userRef)
      ref ! userRef

      it("should add the UserRef to the list of joined users"){
        chatroom.joinedUsers.head should equal(userRef)
      }
    }
  }

  describe("Given a Chatroom has no users (Unit example)"){
    val props: Props = Props.create(classOf[Chatroom])
    val ref: TestActorRef[Chatroom] = TestActorRef.create(system, props, "testA")
    val chatroom: Chatroom = ref.underlyingActor
    chatroom.joinedUsers.size should equal(0)

    describe("when it receives a request from a user to join the chatroom"){
      val userRef: UserRef = new UserRef(system.deadLetters, "user")
      chatroom.joinChatroom(JoinChatroom(userRef))

      it("should add the UserRef to the list of joined users"){
        chatroom.joinedUsers.head should equal(userRef)
      }
    }
  }

  describe("Given a Chatroom has a history"){
    val props = Props.create(classOf[Chatroom])
    val ref = TestActorRef.create(system, props)
    val chatroom: Chatroom = ref.underlyingActor
    val msg = PostToChatroom("test", "user")
    chatroom.chatHistory = chatroom.chatHistory.+:(msg)

    describe("When a user joins the chatroom"){
      val userRef = UserRef(system.deadLetters, "user")
      val request = JoinChatroom(userRef)
      ref.tell(request, self)

      it("(the user) should receive the history"){
        expectMsg(1 second, List(msg))
      }
    }
  }

  describe("Given a Chatroom has a joined user"){
    val props = Props.create(classOf[Chatroom])
    val ref = TestActorRef.create(system, props)
    val chatroom: Chatroom = ref.underlyingActor

    val probe: TestProbe = new TestProbe(system)
    val userRef: UserRef = new UserRef(probe.ref, "user")
    chatroom.joinChatroom(JoinChatroom(userRef))

    describe("when someone posts to the chatroom"){
      val msg = PostToChatroom("test", "user")
      ref.tell(msg, probe.ref)
      it("(joined user) should get an update"){
        probe.expectMsg(msg)
      }
    }
  }

}
