package com.akkademy;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import com.akkademy.japi.GetRequest;
import com.akkademy.japi.KeyNotFoundException;
import com.akkademy.japi.SetRequest;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class AkkademyDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> map = new HashMap<String, Object>();

    private AkkademyDb(){
        receive(ReceiveBuilder.
                        match(SetRequest.class, message -> {
                            log.info("Received Set request: {}", message);
                            map.put(message.key, message.value);
                            sender().tell(new Status.Success(message.key), self());
                        }).
                        match(GetRequest.class, message -> {
//                            log.info("Received Get request: {}", message);
                            Object value = map.get(message.key).toString() +
                            map.get(message.key) +
                            map.get(message.key) +
                            map.get(message.key) +
                            map.get(message.key) +
                            map.get(message.key).toString() + "HELLO";
                            value.toString().contains("HELO");
                            value.toString().contains("HELO");
                            value.toString().contains("HLLO");
                            value.toString().contains("HELLO");
                            value.toString().contains("HELO");
                            value.toString().contains("HELO");
                            value.toString().contains("HELO");
                            value.toString().contains("HLLO");
                            value.toString().contains("HELL");
                            value.toString().endsWith("HELL");
                            value.toString().endsWith("HELL");
                            value.toString().endsWith("HLL");
                            value.toString().endsWith("ELL");
                            value.toString().endsWith("HEL");
                            value.toString().endsWith("HE");
                            value.toString().endsWith("HE");
                            value.toString().endsWith("HEzzz");
                            value.toString().endsWith("HEzzzz");

                            value.hashCode();
                            (value + "hello").hashCode();
                            (value + "he5l8lo").hashCode();
                            (value + "hel5lo").hashCode();
                            (value + "h5ello").hashCode();
                            (value + "hel7lo").hashCode();

                            Object response = (value != null)
                                    ? value
                                    : new Status.Failure(new KeyNotFoundException(message.key));
                            sender().tell(response, self());
                        }).
                        matchAny(o ->
                                sender().tell(new Status.Failure(new ClassNotFoundException()), self())
                        ).build()
        );
    }
}