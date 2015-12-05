package com.akkademy

import akka.actor.{Actor, Stash}
import com.akkademy.messages.{GetRequest, SetRequest}

class RemoteActorProxy extends Actor with Stash {
  override def receive = {
    case GetRequest(key) =>
      stash()
    case x @ SetRequest(key, value, _) =>


  }
}
