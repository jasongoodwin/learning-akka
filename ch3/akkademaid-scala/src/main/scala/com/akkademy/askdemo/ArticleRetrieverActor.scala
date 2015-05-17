//package com.akkademy.askdemo
//
//import akka.actor.SupervisorStrategy.{Escalate, Resume, Restart, Stop}
//import akka.actor.{ForOneStrategy, Actor}
//import akka.actor.Actor.Receive
//
//class ArticleRetrieverActor extends Actor {
//  override def receive: Receive = {
//    case uri: String =>
//  }
//
//  override def supervisorStrategy = {
//    OneForOneStrategy(){
//      case BrokenPlateException => Resume
//      case DrunkenFoolException => Restart
//      case RestaurantFireError => Resume
//      case TiredChefException => Stop
//      case _ => Escalate
//    }
//  }
//
//}
