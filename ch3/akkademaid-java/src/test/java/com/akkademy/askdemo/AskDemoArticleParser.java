package com.akkademy.askdemo;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.japi.pf.ReceiveBuilder;
import akka.util.Timeout;
import scala.PartialFunction;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static scala.compat.compat.FutureConverters.*;
import static akka.pattern.Patterns.ask;

public class AskDemoArticleParser extends AbstractActor {

    private final ActorSelection cacheActor;
    private final ActorSelection httpClientActor;
    private final ActorSelection artcileParseActor;
    private final Timeout timeout;

    public AskDemoArticleParser(String cacheActorPath, String httpClientActorPath, String artcileParseActorPath, Timeout timeout) {
        this.cacheActor = context().actorSelection(cacheActorPath);
        this.httpClientActor = context().actorSelection(httpClientActorPath);
        this.artcileParseActor = context().actorSelection(artcileParseActorPath);
        this.timeout = timeout;
    }

    public PartialFunction receive() {
        return ReceiveBuilder.
                match(ParseArticle.class, msg -> {

                    final CompletionStage cacheResult = toJava(ask(cacheActor, msg.url, timeout));
                    final CompletionStage result = cacheResult.handle((x, t) -> {
                        return (x != null)
                                ? CompletableFuture.completedFuture(x)
                                : toJava(ask(httpClientActor, msg.url, timeout)).
                                thenCompose(rawArticle -> toJava(ask(artcileParseActor, (String) rawArticle, timeout)))
                                ;
                    }).thenCompose(x -> x);

                    final ActorRef senderRef = sender();
                    result.handle((x,t) -> {
                        if(x == null)
                            senderRef.tell(x, self());
                        else
                            senderRef.tell(new akka.actor.Status.Failure(t), self());
                        return null;
                    });

                }).build();
    }
}
