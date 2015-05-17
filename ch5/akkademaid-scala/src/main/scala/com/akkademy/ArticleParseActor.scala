package com.akkademy

import akka.actor.Actor

class ArticleParseActor extends Actor{
  override def receive: Receive = {
    case ParseArticle(htmlString) =>
      val body: String = ArticleParser(htmlString)
      sender() ! body
  }
}

object ArticleParser {
  def apply(html: String) : String =
    de.l3s.boilerpipe.extractors.ArticleExtractor.INSTANCE.getText(html)
}