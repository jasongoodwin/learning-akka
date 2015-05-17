package akkademy;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class ArticleParseActor extends AbstractActor {
  private ArticleParseActor() {
    receive(ReceiveBuilder.
        match(ParseArticle.class, x ->{
                sender().tell(ArticleParser.apply(x.url), self());
                }
        ).
        build());
  }
}
