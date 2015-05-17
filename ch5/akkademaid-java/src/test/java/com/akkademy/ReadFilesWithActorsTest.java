package com.akkademy;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;
import akkademy.ArticleParseActor;
import akkademy.ParseArticle;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class ReadFilesWithActorsTest {
    ActorSystem system = ActorSystem.create();
    @Test
    public void shouldReadFilesWithActors() throws Exception {
        ActorRef workerRouter = system.actorOf(Props.create(ArticleParseActor.class).withRouter(new RoundRobinPool(8)),
                "workerRouter");

        CompletableFuture future = new CompletableFuture();
        ActorRef cameoActor = system.actorOf(Props.create(ExtraActor.class, future));

        IntStream.range(0, 2000).forEach(x -> {
                    workerRouter.tell(
                            new ParseArticle(TestHelper.file)
                            , cameoActor);
                }
        );

        long start = System.currentTimeMillis();
        future.get();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Took: " + elapsedTime);

    }

    public static class ExtraActor extends AbstractActor{
        private final CompletableFuture futureToComplete;
        private int articlesRecieved = 0;

        private ExtraActor(CompletableFuture futureToComplete) {
            this.futureToComplete = futureToComplete;

            receive(ReceiveBuilder.
                    matchAny(x -> {
                                if(++articlesRecieved == 2000){
                                    futureToComplete.complete("Ok");
                                }
                            }
                        ).build());
        }
    }
}
