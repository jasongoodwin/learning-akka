package com.akkademy.clientactor

import akka.actor.{ActorRef, FSM}
import akka.io.Tcp.Connected
import com.akkademy.clientactor.StateContainerTypes.RequestQueue
import com.akkademy.sapi.{GetRequest, SetRequest}

sealed trait State
case object Disconnected extends State
case object Connected extends State
case object ConnectedAndPending extends State

case object Flush
case object ConnectedMsg

object StateContainerTypes {
  type RequestQueue = List[GetRequest]
}

class FSMClientActor(remoteAddress: String) extends FSM[State, RequestQueue]{
  startWith(Disconnected, null)

  private val remoteDb = context.system.actorSelection(s"akka.tcp://akkademy@$remoteAddress/user/akkademy-db")

  when(Disconnected){
    case (_: Connected, container: RequestQueue) =>
      if (container.headOption.isEmpty)
        goto(Connected)
      else
        goto(ConnectedAndPending)
    case (x: GetRequest, container: RequestQueue) =>
      container = container :: x :: Nil
      stay()
  }

  when (Connected) {
    case (x: GetRequest, container: RequestQueue) =>
      container = container :: x :: Nil
      goto(ConnectedAndPending)
  }

  when (ConnectedAndPending) {
    case (Flush, container) =>
      remoteDb ! container;
      container = Nil
      goto(Connected)
    case (x: GetRequest, container: RequestQueue) =>
      container = container :: x :: Nil
      stay()
  }

  initialize()
}
