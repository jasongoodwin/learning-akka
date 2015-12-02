package com.akkachat

import akka.actor.ActorRef

case class UserRef(actor: ActorRef, name: String)
