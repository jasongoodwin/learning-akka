package com.akkademy;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.japi.pf.ReceiveBuilder;
import akka.util.Timeout;
import com.akkademy.messages.GetRequest;
import scala.PartialFunction;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static akka.pattern.Patterns.ask;
import static scala.compat.java8.FutureConverters.toJava;

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

    /**
     * Note there are 3 asks so this potentially creates 6 extra objects:
     * - 3 Promises
     * - 3 Extra actors
     * It's a bit simpler than the tell example.
     */
    public PartialFunction receive() {
        return ReceiveBuilder.
                match(ParseArticle.class, msg -> {
                    final CompletionStage cacheResult = toJava(ask(cacheActor, new GetRequest(msg.url), timeout));
                    final CompletionStage result = cacheResult.handle((x, t) -> {
                        return (x != null)
                                ? CompletableFuture.completedFuture(x)
                                : toJava(ask(httpClientActor, msg.url, timeout)).
                                thenCompose(rawArticle -> toJava(
                                                ask(artcileParseActor,
                                                        new ParseHtmlArticle(msg.url,
                                                                ((HttpResponse) rawArticle).body), timeout))
                                );
                    }).thenCompose(x -> x);

                    final ActorRef senderRef = sender();
                    result.handle((x,t) -> {
                        if(x != null){
                            if(x instanceof ArticleBody){
                                String body = ((ArticleBody) x).body; //parsed article
                                cacheActor.tell(body, self()); //cache it
                                senderRef.tell(body, self()); //reply
                            } else if(x instanceof String) //cached article
                                senderRef.tell(x, self());
                        } else if( x == null )
                            senderRef.tell(new akka.actor.Status.Failure((Throwable)t), self());
                        return null;
                    });

                }).build();
    }
}
