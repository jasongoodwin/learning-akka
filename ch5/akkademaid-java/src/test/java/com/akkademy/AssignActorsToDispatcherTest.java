package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.RoundRobinGroup;
import akka.routing.RoundRobinPool;
import akkademy.ArticleParseActor;
import akkademy.ParseArticle;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AssignActorsToDispatcherTest {
    ActorSystem system = ActorSystem.create();
    @Test
    public void shouldReadFilesWithActorsInAnotherDispatcher() throws Exception {

        List<ActorRef> routees = Arrays.asList(1,2,3,4,5,6,7,8).stream().map(x ->
                system.actorOf(Props.create(ArticleParseActor.class).
                withDispatcher("article-parsing-dispatcher"))
        ).collect(Collectors.toList());

        Iterable<String> routeeAddresses = routees.
                stream().
                map(x -> x.path().toStringWithoutAddress()).
                collect(Collectors.toList());

        ActorRef workerRouter = system.actorOf(new RoundRobinGroup(routeeAddresses).props());

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
        System.out.println("ActorsAssignedToDispatcherTest Took: " + elapsedTime);

    }
}
