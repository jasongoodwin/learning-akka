package com.akkademy

import akka.actor.{Props, ActorSystem, Status, Actor}
import akka.cluster.{ClusterEvent, Cluster}
import akka.cluster.ClusterEvent.{UnreachableMember, MemberEvent}
import akka.event.Logging
import com.akkademy.sapi.{KeyNotFoundException, GetRequest, SetRequest}
import scala.collection.mutable.HashMap

class AkkademyDb extends Actor {
  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive = {
    case SetRequest(key, value) =>
      log.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)
      sender() ! Status.Success
    case GetRequest(key) =>
      log.info("received GetRequest - key: {}", key)
      val response: Option[Object] = map.get(key)
      response match{
        case Some(x) => sender() ! x
        case None => sender() ! Status.Failure(new KeyNotFoundException(key))
      }
    case o => Status.Failure(new ClassNotFoundException)
  }
}


class ClusterController extends Actor {
  val log = Logging(context.system, this)
  val cluster = Cluster(context.system)

  override def preStart() {
    cluster.subscribe(self, classOf[MemberEvent], classOf[UnreachableMember])
  }

  override def postStop() {
    cluster.unsubscribe(self)
  }

  override def receive = {
    case x: MemberEvent => log.info("MemberEvent: {}", x)
    case x: UnreachableMember => log.info("UnreachableMember {}: ", x)
  }
}


object Main extends App {
  val system = ActorSystem("Akkademy")
  val clusterController = system.actorOf(Props[ClusterController], "clusterController")
}