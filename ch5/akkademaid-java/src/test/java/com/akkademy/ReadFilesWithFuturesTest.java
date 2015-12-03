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
import com.jasongoodwin.monads.Futures;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReadFilesWithFuturesTest {
    @Test
    public void shouldReadFilesWithFutures() throws Exception {
        List<Integer> list = IntStream.range(0, 2000).boxed().collect(Collectors.toList());
        List futures = (List) list
                .stream()
                .map(x -> CompletableFuture.supplyAsync(() -> ArticleParser.apply(TestHelper.file)))
                .collect(Collectors.toList());

        long start = System.currentTimeMillis();
        com.jasongoodwin.monads.Futures.sequence(futures).get();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("ReadFilesWithFuturesTest Took: " + elapsedTime);
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

