package com.example;

import akka.actor.ActorSystem;
import akka.agent.Agent;

public class JavaAgentExample {
    public static void apply() throws Exception{
        ActorSystem system = ActorSystem.create();
        Agent<Integer> account = Agent.create(25, system.dispatcher());

        final Integer ammountToWithdraw = 20;

        account.send(new akka.dispatch.Mapper<Integer, Integer>() {
            public Integer apply(Integer i) {
                if(ammountToWithdraw <= i)
                    return i - ammountToWithdraw;
                else
                    return i;
            }
        });

        Thread.sleep(1000);
        System.out.println(account.get()); //5

        account.send(new akka.dispatch.Mapper<Integer, Integer>() {
            public Integer apply(Integer i) {
                if(ammountToWithdraw <= i)
                    return i - ammountToWithdraw;
                else
                    return i;
            }
        });

        Thread.sleep(1000);
        System.out.println(account.get()); //still 5

    }
}
