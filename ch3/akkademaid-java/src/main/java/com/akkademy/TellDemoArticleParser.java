package com.akkademy;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.util.Timeout;
import com.akkademy.messages.SetRequest;
import scala.PartialFunction;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TellDemoArticleParser extends AbstractActor {

    private final ActorSelection cacheActor;
    private final ActorSelection httpClientActor;
    private final ActorSelection artcileParseActor;
    private final Timeout timeout;

    public TellDemoArticleParser(String cacheActorPath, String httpClientActorPath, String artcileParseActorPath, Timeout timeout) {
        this.cacheActor = context().actorSelection(cacheActorPath);
        this.httpClientActor = context().actorSelection(httpClientActorPath);
        this.artcileParseActor = context().actorSelection(artcileParseActorPath);
        this.timeout = timeout;
    }

    public PartialFunction receive() {
        return ReceiveBuilder.
                match(ParseArticle.class, msg -> {
                    ActorRef extraActor = buildExtraActor(sender());
                    cacheActor.tell(msg.url, extraActor);
                    httpClientActor.tell(msg.url, extraActor);

                    context().system().scheduler().scheduleOnce(Duration.create(3, TimeUnit.SECONDS),
                            extraActor, "timeout", context().system().dispatcher(), ActorRef.noSender());
                }).build();
    }

    private ActorRef buildExtraActor(ActorRef senderRef){

        return context().actorOf(Props.create(new AbstractActor() {
                    public PartialFunction receive() {
                        return ReceiveBuilder
                                .matchEquals(String.class, x -> x.equals("timeout"), x -> {
                                    senderRef.tell(new akka.actor.Status.Failure(new TimeoutException("timeout!")), ActorRef.noSender());
                                    context().stop(self());
                                })
                                .match(String.class, article -> {
                                    senderRef.tell(article, ActorRef.noSender());
                                    context().stop(self());
                                })
                                .match(HttpResponse.class, rawArticle -> {
                                    artcileParseActor.tell(rawArticle.body, self());
                                })
                                .match(ArticleBody.class, article -> {
                                    cacheActor.tell(new SetRequest(article.uri, article.body), self());
                                    senderRef.tell(article.body, ActorRef.noSender());
                                    context().stop(self());
                                })

                                .build();
                    }
                }.getClass())
        );

    }
}
