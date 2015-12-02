package com.akkademy

import akka.actor.Actor

class ParsingActor extends Actor{
  override def receive: Receive = {
    case ParseArticle(htmlString) =>
      de.l3s.boilerpipe.extractors.ArticleExtractor.INSTANCE.getText(htmlString)
  }
}
