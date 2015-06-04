package com.akkademy;

import akka.actor.*;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RandomGroup;
import akka.routing.RoundRobinGroup;
import akka.routing.RoundRobinPool;
import akkademy.ArticleParseActor;
import akkademy.ParseArticle;
import org.junit.Test;
import scala.concurrent.duration.FiniteDuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class BalancingDispatcherTest {
    ActorSystem system = ActorSystem.create();

    @Test
    public void shouldReadFilesWithActors() throws Exception {

        CompletableFuture.runAsync(() -> System.out.println("run in ec"), system.dispatcher());

        //Create one actor to gain a reference to it.
        ActorRef balancingDispatcherWorker1 = system.actorOf(Props.create(ArticleParseActor.class).
                        withDispatcher("balancing-dispatcher"));

        //Create 7 more actors. They all share the same mailbox
        IntStream.range(1, 7).forEach(x -> {
            system.actorOf(Props.create(ArticleParseActor.class).
                    withDispatcher("balancing-dispatcher"));
        });

        CompletableFuture future = new CompletableFuture();
        ActorRef cameoActor = system.actorOf(Props.create(TestCameoActor.class, future));

        IntStream.range(1, 2000).forEach(x -> {
                    balancingDispatcherWorker1.tell(
                            new ParseArticle(TestHelper.file)
                            , cameoActor);
                }
        );

        long start = System.currentTimeMillis();
        future.get();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Took: " + elapsedTime);

    }
}
