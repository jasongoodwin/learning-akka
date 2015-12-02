package com.akkademy;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import akka.pattern.CircuitBreaker;
import static akka.pattern.Patterns.ask;

import akka.pattern.Patterns;
import akka.util.Timeout;
import com.akkademy.japi.GetRequest;
import com.akkademy.japi.KeyNotFoundException;
import com.akkademy.japi.SetRequest;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.FiniteDuration;
import static scala.compat.java8.FutureConverters.*;

import java.util.HashMap;
import java.util.Map;


class SlowAkkademyDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> map = new HashMap<String, Object>();

    private SlowAkkademyDb(){
        receive(ReceiveBuilder.
                        match(SetRequest.class, message -> {
                            System.out.println("set request: " + message);
                            map.put(message.key, message.value);
                            sender().tell(new Status.Success(message.key), self());
                        }).
                        match(GetRequest.class, message -> {
                            System.out.println("get request: " + message);
                            Thread.sleep(70); //slow down the actor's response
                            Object value = map.get(message.key);
                            Object response = (value != null)
                                    ? value
                                    : new Status.Failure(new KeyNotFoundException(message.key));
                            System.out.println("going to reply with: " + response);
                            sender().tell(response, self());
                        }).
                        matchAny(o -> {
                                    System.out.println("unknown message " + o);
                                    sender().tell(new Status.Failure(new ClassNotFoundException()), self());
                                }
                        ).build()
        );
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        ActorSystem system = ActorSystem.create("Akkademy");

        CircuitBreaker breaker =
                new CircuitBreaker(system.scheduler(),
                        10,
                        FiniteDuration.create(1, "second"),
                        FiniteDuration.create(1, "second"),
                        system.dispatcher()).
                        onOpen(() -> {
                            System.out.println("circuit breaker opened!");
                        }).
                        onClose(() -> {
                            System.out.println("circuit breaker opened!");
                        }).
                        onHalfOpen(() -> {
                            System.out.println("circuit breaker opened!");
                        });

        Timeout timeout = Timeout.apply(2000);

        ActorRef db = system.actorOf(Props.create(SlowAkkademyDb.class));
        Await.result(Patterns.ask(db, new SetRequest("key", "value"),  timeout), timeout.duration());

        for(int i=0; i<10000000; i++){
            Future future = breaker.callWithCircuitBreaker(() -> Patterns.ask(db, new GetRequest("key"),  timeout));
            toJava(future).handle((x,t) -> {
                if(t != null){
                    System.out.println("got it: " + x);
                }else{
                    System.out.println("error: " + t.toString());
                }

                return null;
            });

            Thread.sleep(50);
        }
    }
}
