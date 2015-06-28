package com.akkademy

import akka.actor.Actor
import com.akkademy.ParseArticle

class ArticleParseActor extends Actor{
  override def receive: Receive = {
    case htmlString: String =>
      val body: String = ArticleParser(htmlString)
      sender() ! body
    case _ =>
      println("msg!")
  }
}

object ArticleParser {
  def apply(html: String) : String =
    de.l3s.boilerpipe.extractors.ArticleExtractor.INSTANCE.getText(html)
}