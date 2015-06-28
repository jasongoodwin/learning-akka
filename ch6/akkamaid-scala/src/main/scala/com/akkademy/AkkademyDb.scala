//package com.akkademy
//
//import akka.actor.{Props, ActorSystem, Status, Actor}
//import akka.cluster.{ClusterEvent, Cluster}
//import akka.cluster.ClusterEvent.{UnreachableMember, MemberEvent}
//import akka.event.Logging
//import com.akkademy.sapi.{KeyNotFoundException, GetRequest, SetRequest}
//import scala.collection.mutable.HashMap
//
//class AkkademyDb extends Actor {
//  val map = new HashMap[String, Object]
//  val log = Logging(context.system, this)
//
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
//}
//
//
//class ClusterController extends Actor {
//  val log = Logging(context.system, this)
//  val cluster = Cluster(context.system)
//
//  override def preStart() {
//    cluster.subscribe(self, classOf[MemberEvent], classOf[UnreachableMember])
//  }
//
//  override def postStop() {
//    cluster.unsubscribe(self)
//  }
//
//  override def receive = {
//    case x: MemberEvent => log.info("MemberEvent: {}", x)
//    case x: UnreachableMember => log.info("UnreachableMember {}: ", x)
//  }
//}
//
//
//object Main extends App {
//  val system = ActorSystem("Akkademy")
//  val clusterController = system.actorOf(Props[ClusterController], "clusterController")
//}
////
////package com.akkademy
////
////import akka.actor._
////import com.typesafe.config.ConfigFactory
////import akka.contrib.pattern.{ClusterClient, ClusterReceptionistExtension}
////
////object DemoMaster {
////
////  def main(args: Array[String]): Unit = {
////    val config = ConfigFactory.parseString("""
////     akka {
////       actor {
////         provider = "akka.cluster.ClusterActorRefProvider"
////       }
////       remote {
////         transport = "akka.remote.netty.NettyRemoteTransport"
////         log-remote-lifecycle-events = off
////         netty.tcp {
////           hostname = "127.0.0.1"
////           port = 2551
////         }
////       }
////
////       cluster {
////         seed-nodes = [
////           "akka.tcp://ClusterSystem@127.0.0.1:2551"
////           ]
////
////         roles = [master]
////
////         auto-down = on
////       }
////     }""")
////
////    val system = ActorSystem("ClusterSystem", ConfigFactory.load(config))
////    val master = system.actorOf(Props[ClusterMaster], "master")
////    ClusterReceptionistExtension(system).registerService(master)
////  }
////
////  class ClusterMaster extends Actor with ActorLogging {
////    def receive = {
////      case e =>
////        log.info(s"from master : $e : $sender")
////        sender ! "master : how are you?"
////    }
////  }
////}
////
////object DemoMember {
////
////  def main(args: Array[String]) {
////    val config = ConfigFactory.parseString("""
////     akka {
////       actor {
////         provider = "akka.cluster.ClusterActorRefProvider"
////       }
////
////       remote {
////         transport = "akka.remote.netty.NettyRemoteTransport"
////         log-remote-lifecycle-events = off
////         netty.tcp {
////          hostname = "127.0.0.1"
////          port = 3000
////         }
////       }
////
////       cluster {
////         seed-nodes = [
////           "akka.tcp://ClusterSystem@127.0.0.1:2551"
////           ]
////
////         auto-down = on
////       }
////     }""")
////
////    val system = ActorSystem("ClusterSystem", ConfigFactory.load(config))
////    val clusterMember = system.actorOf(Props[ClusterMember], "member")
////    ClusterReceptionistExtension(system).registerService(clusterMember)
////  }
////
////  class ClusterMember extends Actor with ActorLogging {
////    def receive = {
////      case e =>
////        log.info(s"from member : $e : $sender")
////        sender ! "member : how are you?"
////    }
////  }
////}
////
////object DemoClient {
////
////  def main(args : Array[String]) {
////    val config = ConfigFactory.parseString("""
////     akka {
////       actor {
////         provider = "akka.remote.RemoteActorRefProvider"
////       }
////
////       remote {
////         transport = "akka.remote.netty.NettyRemoteTransport"
////         log-remote-lifecycle-events = off
////         netty.tcp {
////          hostname = "127.0.0.1"
////          port = 5000
////         }
////       }
////     }""")
////
////    val system = ActorSystem("OTHERSYSTEM", ConfigFactory.load(config))
////    val initialContacts = Set(
////      system.actorSelection("akka.tcp://ClusterSystem@127.0.0.1:2551/user/receptionist"),
////      system.actorSelection("akka.tcp://ClusterSystem@127.0.0.1:3000/user/receptionist"))
////
////    val c = system.actorOf(ClusterClient.props(initialContacts), "os-client")
////
////    (1 to 1000).map { i =>
////      c ! ClusterClient.Send("/user/master", s"hello - $i", localAffinity = true)
////      c ! ClusterClient.Send("/user/member", s"hello - $i", localAffinity = true)
////
////      Thread.sleep(1000)
////    }
////  }
////}