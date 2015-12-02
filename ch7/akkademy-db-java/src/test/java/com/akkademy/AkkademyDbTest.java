package com.akkademy;

import static org.junit.Assert.assertEquals;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.pattern.Patterns;
import akka.testkit.TestActorRef;
import com.akkademy.japi.GetRequest;
import com.akkademy.japi.SetRequest;
import org.junit.Test;
import scala.Int;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class AkkademyDbTest {

    ActorSystem system = ActorSystem.create();
//
//    @Test
//    public void itShouldPlaceKeyValueFromSetMessageIntoMap() {
//        TestActorRef<AkkademyDb> actorRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
//        actorRef.tell(new SetRequest("key", "value"), ActorRef.noSender());
//
//        AkkademyDb akkademyDb = actorRef.underlyingActor();
//        assertEquals(akkademyDb.map.get("key"), "value");
//    }
//
//    @Test
//    public void itShouldBeSlow() {
//        system.actorOf(Props.create(AkkademyDb.class));
//
//        actorRef.tell(new SetRequest("key", "value"), ActorRef.noSender());
//
//
//        AkkademyDb akkademyDb = actorRef.underlyingActor();
//        assertEquals(akkademyDb.map.get("key"), "value");
//    }

    //Mymailbox

    //Default
//    9546
//            4374
//            5263
//            5505
//            5015
//            5123
//            5198
//            5291
//            5140
//            4912
//            4982
//            4761
//            5020
//            5188
//            4909
//            4733
//            4709
//            4709
//            4823
//            4769





    //Round 2
    //Default
//    32079
//            27055
//            25906
//            24006
//            23400
//            23869
//            18748
//            22037
//            23809
//            19537
//            23515
//            20366
//            22203
//            22071
//            18617
//            24888
//            21845
//            24996
//            20292
//            18222

    //node queue
//    31582
//            24876
//            21379
//            21047
//            23339
//            22580
//            18417
//            21413
//            22009
//            22880
//            23650
//            22701
//            18047
//            22408
//            21956
//            21993
//            22268
//            17552
//            22520
//            21734

    @Test
    public void itShouldBeFast() throws Exception {
//        ActorRef actor = system.actorOf(Props.create(AkkademyDb.class).withMailbox("akka.actor.mymailbox"));
        ActorRef actor = system.actorOf(Props.create(AkkademyDb.class));

        Arrays.asList(1).stream().map(x -> {
            Long time = runTest(actor);
            System.out.println("K done: " + time);
            return time;
        }).collect(Collectors.toList()).forEach(x -> System.out.println(x));
    }

    Random random = new Random();

    public Long runTest(ActorRef actor) {
        actor.tell(new SetRequest("key", "value"), ActorRef.noSender());

        Long startTime = System.currentTimeMillis();



        for(long i=0; i<100000000000L; i++)
            actor.tell(new GetRequest(Integer.toString(random.nextInt())), null);
        System.out.println("PRINT THE TIME NOW: " +  (System.currentTimeMillis() - startTime));


        try{
            Await.result(Patterns.ask(actor, new GetRequest("key"), 40000L), Duration.create("40 seconds"));
            return (System.currentTimeMillis() - startTime);
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }

}
