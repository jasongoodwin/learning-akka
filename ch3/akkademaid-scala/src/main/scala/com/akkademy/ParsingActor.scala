package com.akkademy

import akka.actor.Actor

class ParsingActor extends Actor{
  override def receive: Receive = {
    case htmlString: String =>
      sender() ! de.l3s.boilerpipe.extractors.ArticleExtractor.INSTANCE.getText(htmlString)
    case x =>
      println("unknown message " + x)
  }
}
