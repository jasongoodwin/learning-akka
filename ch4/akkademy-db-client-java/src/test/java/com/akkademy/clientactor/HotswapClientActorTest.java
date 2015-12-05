package com.akkademy.clientactor;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.Status;
import akka.testkit.TestActorRef;
import akka.testkit.TestProbe;
import akka.util.Timeout;
import com.akkademy.AkkademyDb;
import com.akkademy.messages.GetRequest;
import com.akkademy.messages.SetRequest;
import com.typesafe.config.ConfigFactory;
import org.junit.Test;

public class HotswapClientActorTest {
    ActorSystem system = ActorSystem.create("testSystem", ConfigFactory.defaultReference());
    Timeout timeout = Timeout.longToTimeout(10000);

    @Test
    public void itShouldSet() throws Exception {
        TestActorRef<AkkademyDb> dbRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
        AkkademyDb db = dbRef.underlyingActor();

        TestProbe probe = TestProbe.apply(system);
        TestActorRef<HotswapClientActor> clientRef =
                TestActorRef.create(system, Props.create(HotswapClientActor.class, dbRef.path().toString()));

        clientRef.tell(new SetRequest("testkey", "testvalue", probe.ref()), probe.ref());

        probe.expectMsg(new Status.Success("testkey"));
        assert(db.map.get("testkey") == "testvalue");
    }

    @Test
    public void itShouldGet() throws Exception {
        TestActorRef<AkkademyDb> dbRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
        AkkademyDb db = dbRef.underlyingActor();
        db.map.put("testkey", "testvalue");

        TestProbe probe = TestProbe.apply(system);
        TestActorRef<HotswapClientActor> clientRef =
                TestActorRef.create(system, Props.create(HotswapClientActor.class, dbRef.path().toString()));


        clientRef.tell(new GetRequest("testkey"), probe.ref());
        probe.expectMsg("testvalue");
    }
}
