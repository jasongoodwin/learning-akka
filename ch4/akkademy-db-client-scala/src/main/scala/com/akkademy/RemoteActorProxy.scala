package com.akkademy

import akka.actor.{Stash, Actor}
import akka.actor.Actor.Receive
import com.akkademy.sapi.{SetRequest, GetRequest}

class RemoteActorProxy extends Actor with Stash {
  override def receive = {
    case GetRequest(key) =>
      stash()
    case x @ SetRequest(key, value) =>


  }
}
