package com.akkachat

case class JoinChatroom(userRef: UserRef)
case class PostToChatroom(line: String, username: String)