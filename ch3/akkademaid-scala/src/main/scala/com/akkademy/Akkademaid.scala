package com.akkademy

import akka.actor.Actor
import akka.actor.Actor.Receive

class AkkademaidActor extends Actor{
  override def receive: Receive = {
    case x =>
      de.l3s.boilerpipe.extractors.ArticleExtractor.INSTANCE.getText("barf")
  }
}
