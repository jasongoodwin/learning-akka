package com.akkademy;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;
import akkademy.ArticleParseActor;
import akkademy.ArticleParser;
import akkademy.ParseArticle;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReadFilesWithFuturesTest {
    @Test
    public void shouldReadFilesWithActors() throws Exception {
        List<Integer> list = IntStream.range(0, 2000).boxed().collect(Collectors.toList());
        List futures = (List) list
                .stream()
                .map(x -> CompletableFuture.supplyAsync(() -> ArticleParser.apply(TestHelper.file)))
                .collect(Collectors.toList());

        long start = System.currentTimeMillis();
        sequence(futures).get();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Took: " + elapsedTime);
    }

    private static <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futures) {
        CompletableFuture<Void> allDoneFuture =
                CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        return allDoneFuture.thenApply(v ->
                        futures.stream().
                                map(future -> future.join()).
                                collect(Collectors.<T>toList())
        );
    }
}

//public class ReadFilesWithActorsTest {
//    ActorSystem system = ActorSystem.create();
//    @Test
//    public void shouldReadFilesWithActors() throws Exception {
//        ActorRef workerRouter = system.actorOf(Props.create(ArticleParseActor.class).withRouter(new RoundRobinPool(4)),
//                "workerRouter");
//
//        CompletableFuture future = new CompletableFuture();
//        ActorRef cameoActor = system.actorOf(Props.create(ExtraActor.class, future));
//
//        IntStream.range(0, 2000).forEach(x -> {
//                    workerRouter.tell(
//                            new ParseArticle(TestHelper.file)
//                            , cameoActor);
//                }
//        );
//
//        long start = System.currentTimeMillis();
//        future.get();
//        long elapsedTime = System.currentTimeMillis() - start;
//        System.out.println("Took: " + elapsedTime);
//
//    }
//
//    public static class ExtraActor extends AbstractActor {
//        private final CompletableFuture futureToComplete;
//        private int articlesRecieved = 0;
//
//        private ExtraActor(CompletableFuture futureToComplete) {
//            this.futureToComplete = futureToComplete;
//
//            receive(ReceiveBuilder.
//                    matchAny(x -> {
//                                if (++articlesRecieved == 2000) {
//                                    futureToComplete.complete("Ok");
//                                }
//                            }
//                    ).build());
//        }
//    }
//}

