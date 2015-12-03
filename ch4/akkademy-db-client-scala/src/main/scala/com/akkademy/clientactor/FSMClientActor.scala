package com.akkademy.clientactor

import akka.actor.FSM
import akka.io.Tcp.Connected
import com.akkademy.clientactor.StateContainerTypes.RequestQueue
import com.akkademy.messages.GetRequest

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
  private val remoteDb = context.system.actorSelection(s"akka.tcp://akkademy@$remoteAddress/user/akkademy-db")

  startWith(Disconnected, null)

  when(Disconnected){
    case Event(_: Connected, container: RequestQueue) =>
      if (container.headOption.isEmpty)
        goto(Connected)
      else
        goto(ConnectedAndPending)
    case Event(x: GetRequest, container: RequestQueue) =>
      stay using (container :+ x)
  }

  when (Connected) {
    case Event(x: GetRequest, container: RequestQueue) =>
      goto(ConnectedAndPending) using(container :+ x)
  }

  when (ConnectedAndPending) {
    case Event(Flush, container) =>
      remoteDb ! container;
      goto(Connected) using Nil
    case Event(x: GetRequest, container: RequestQueue) =>
      stay using(container :+ x)
  }

  initialize()
}
