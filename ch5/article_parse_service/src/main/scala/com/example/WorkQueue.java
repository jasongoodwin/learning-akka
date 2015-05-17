package com.example;

import akka.actor.*;

import java.util.ArrayList;
import java.util.List;

class ArticleParseRequest{

}

class ArticleExtractor extends AbstractActor{

}

class WorkQueue {
    ActorSystem system = ActorSystem.apply("system");

    List<ArticleParseRequest> queue = new ArrayList();
    ActorRef articleExtractor = system.actorOf(Props.create(ArticleExtractor.class));

    private ArticleParseRequest getNextMessage() {
        ArticleParseRequest req = queue.get(0);
        queue.remove(0);
        return req;
    }

    public void assignWork() {
        articleExtractor.tell(getNextMessage(), null);
    }
}