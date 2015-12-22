package com.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import scala.concurrent.duration.Duration;

import com.example.PingActor;
import com.example.PongActor;

public class PingPongActorTest {

    static ActorSystem system;

    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
    }

    @AfterClass
    public static void tearDown() {
        JavaTestKit.shutdownActorSystem(system);
        system = null;
    }

    @Test
    public void testPingActor() {
        new JavaTestKit(system) {{
            final ActorRef pingActor = system.actorOf(PingActor.props());
            pingActor.tell(new PongActor.PongMessage("pong"), getRef());

            final String pingResult = new ExpectMsg<String>("ping message") {
                // do not put code outside this method, will run afterwards
                protected String match(Object in) {
                    if (in instanceof PingActor.PingMessage) {
                        PingActor.PingMessage ping = (PingActor.PingMessage) in;
                        return ping.getText();
                    }
                    throw noMatch();
                }
            }.get(); // this extracts the received message

            assertEquals("ping", pingResult);
        }};
    }

    @Test
    public void testPongActor() {
        new JavaTestKit(system) {{
            final ActorRef pongActor = system.actorOf(PongActor.props());
            pongActor.tell(new PingActor.PingMessage("ping"), getRef());

            final String pongResult = new ExpectMsg<String>("pong message") {
                // do not put code outside this method, will run afterwards
                protected String match(Object in) {
                    if (in instanceof PongActor.PongMessage) {
                        PongActor.PongMessage pong = (PongActor.PongMessage) in;
                        return pong.getText();
                    }
                    throw noMatch();
                }
            }.get(); // this extracts the received message

            assertEquals("pong", pongResult);
        }};
    }
}