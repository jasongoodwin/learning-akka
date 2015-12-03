package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.BalancingPool;
import akka.routing.RoundRobinPool;
import akkademy.ArticleParseActor;
import akkademy.ParseArticle;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class BalancingPoolTest {
    ActorSystem system = ActorSystem.create();
    @Test
    public void shouldReadFilesWithBalancingPool() throws Exception {
        ActorRef workerRouter = system.actorOf(new BalancingPool(8).props(Props.create(ArticleParseActor.class)),
                "balancing-pool-router");

        CompletableFuture future = new CompletableFuture();
        ActorRef cameoActor = system.actorOf(Props.create(TestCameoActor.class, future));

        IntStream.range(0, 2000).forEach(x -> {
                    workerRouter.tell(
                            new ParseArticle(TestHelper.file)
                            , cameoActor);
                }
        );

        long start = System.currentTimeMillis();
        future.get();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("BalancingPoolTest Took: " + elapsedTime);

    }
}
