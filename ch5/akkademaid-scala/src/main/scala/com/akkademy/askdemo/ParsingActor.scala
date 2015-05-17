package com.akkademy.askdemo

import akka.actor.Actor

class ParsingActor extends Actor{
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