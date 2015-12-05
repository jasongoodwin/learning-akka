package com.akkademy;

import static org.junit.Assert.assertEquals;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.Status;
import akka.testkit.TestActorRef;
import akka.testkit.TestProbe;
import com.akkademy.messages.SetRequest;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AkkademyDbTest {

    ActorSystem system = ActorSystem.create("system", ConfigFactory.empty()); //Ignore the config for remoting

    @Test
    public void itShouldPlaceKeyValueFromSetMessageIntoMap() {
        TestProbe testProbe = TestProbe.apply(system);
        TestActorRef<AkkademyDb> actorRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
        AkkademyDb akkademyDb = actorRef.underlyingActor();

        actorRef.tell(new SetRequest("key", "value", testProbe.ref()), ActorRef.noSender());

        assertEquals(akkademyDb.map.get("key"), "value");
    }

    @Test
    public void itShouldPlaceKeyValuesFromListOfSetMessageIntoMap() {
        TestProbe testProbe = TestProbe.apply(system);
        TestActorRef<AkkademyDb> actorRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
        AkkademyDb akkademyDb = actorRef.underlyingActor();

        List list = Arrays.asList(
                new SetRequest("key2", "value2", testProbe.ref()),
                new SetRequest("key3", "value3", testProbe.ref()));
        actorRef.tell(list, ActorRef.noSender());

        assertEquals(akkademyDb.map.get("key2"), "value2");
        assertEquals(akkademyDb.map.get("key3"), "value3");

        testProbe.expectMsg(new Status.Success("key2"));
        testProbe.expectMsg(new Status.Success("key3"));
    }

}
