package com.akkademy

import org.scalatest.{Matchers, FlatSpec}
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class ArticleParseWithFuturesSpec extends FlatSpec with Matchers {
  import scala.concurrent.ExecutionContext.Implicits.global

  "ArticleParser" should "do work concurrently with futures" in {
    val futures = (1 to 2000).map(x => {
      Future(ArticleParser.apply(TestHelper.file))
    })

    TestHelper.profile(() => Await.ready(Future.sequence(futures), 30 seconds), "Futures")
  }
}
