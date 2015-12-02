package com.akkachat;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

import java.util.ArrayList;
import java.util.List;

public class Chatroom extends AbstractActor{
    List<Messages.PostToChatroom> chatHistory = new ArrayList<>();
    List<UserRef> joinedUsers = new ArrayList<>();

    @Override
    public PartialFunction<Object, BoxedUnit> receive() {
        return ReceiveBuilder.
                match(Messages.JoinChatroom.class, x -> sender().tell(joinChatroom(x), self())).
                match(Messages.PostToChatroom.class, msg -> joinedUsers.forEach(x -> x.actor.tell(msg, self()))).
                matchAny(o -> System.out.println("received unknown message")).build();
    }

    public List<Messages.PostToChatroom> joinChatroom(Messages.JoinChatroom msg) {
        joinedUsers.add(msg.userRef);
        return chatHistory;
    }
}
