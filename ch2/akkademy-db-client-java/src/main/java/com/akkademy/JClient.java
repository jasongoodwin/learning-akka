package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.akkademy.japi.GetRequest;
import com.akkademy.japi.SetRequest;

import java.util.concurrent.CompletionStage;

import static akka.pattern.Patterns.ask;
import static scala.compat.java8.FutureConverters.toJava;

public class JClient {
    private final ActorSystem system = ActorSystem.create("LocalSystem");
    private final ActorRef remoteDb;

    public JClient(String remoteAddress){
        remoteDb = system.actorFor("akka.tcp://akkademy@" + remoteAddress + "/user/akkademy-db");
    }

    public CompletionStage set(String key, Object value) {
        return toJava(ask(remoteDb, new SetRequest(key, value), 2000));
    }

    public CompletionStage<Object> get(String key){
        return toJava(ask(remoteDb, new GetRequest(key), 2000));
    }
}
