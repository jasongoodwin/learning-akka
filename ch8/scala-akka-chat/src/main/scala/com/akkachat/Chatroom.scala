package com.akkachat

import akka.actor.Actor

class Chatroom extends Actor {
  var joinedUsers: Seq[UserRef] = Seq.empty
  var chatHistory: Seq[PostToChatroom] = Seq.empty
  override def receive: Receive = {
    case x: JoinChatroom =>
      sender ! joinChatroom(x)
    case _ =>
      println("unimplemented")
  }

  def joinChatroom(joinChatroom: JoinChatroom) = {
    joinedUsers = joinedUsers :+ joinChatroom.userRef
    chatHistory
  }
}
