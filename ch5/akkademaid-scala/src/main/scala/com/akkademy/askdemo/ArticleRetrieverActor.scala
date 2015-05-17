package com.akkademy.askdemo

import akka.actor.Actor

class ArticleRetrieverActor extends Actor {
  override def receive = {
    case uri: String =>
  }
}
