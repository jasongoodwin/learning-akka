package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestProbe;
import akka.util.Timeout;
import com.akkademy.clientactor.FSMClientActor;
import com.akkademy.messages.GetRequest;
import org.junit.Test;
import scala.concurrent.Future;

import static akka.pattern.Patterns.ask;

public class FSMClientActorTest {
    ActorSystem system = ActorSystem.create("testSystem");
    Timeout timeout = Timeout.longToTimeout(10000);

    TestProbe cacheProbe = new TestProbe(system);

    @Test
    public void itShouldStashMessagesBeforeConnect() throws Exception {
        ActorRef fsmClientActorTest =
                system.actorOf(Props.create(FSMClientActor.class, cacheProbe.ref().path().toString()));

        Future f = ask(fsmClientActorTest, new GetRequest("testkey"), timeout);


    }

}
