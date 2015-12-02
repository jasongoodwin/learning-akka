package com.akkachat;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.DeadLetter;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import akka.testkit.TestActorRef;
import akka.testkit.TestProbe;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ChatroomTest extends TestCase {
    static ActorSystem system = ActorSystem.apply();

    @Test
    public void testShouldAddUserToJoinedUsersWhenJoiningTest() {
        //Given a Chatroom has no users
        Props props = Props.create(Chatroom.class);
        TestActorRef<Chatroom> ref = TestActorRef.create(system, props);
        Chatroom chatroom = ref.underlyingActor();
        assertEquals(chatroom.joinedUsers.size(), 0);

        //When it receives a request from a user to join the chatroom
        UserRef userRef = new UserRef(system.deadLetters(), "user");
        Messages.JoinChatroom request = new Messages.JoinChatroom(userRef);
        ref.tell(request, system.deadLetters());

        //It should add the UserRef to its list of joined users
        assertEquals(chatroom.joinedUsers.get(0), userRef);
    }

    @Test
    public void testShouldAddUserToJoinedUsersWhenJoiningUnitTest() {
        Props props = Props.create(Chatroom.class);
        TestActorRef<Chatroom> ref = TestActorRef.create(system, props);
        Chatroom chatroom = ref.underlyingActor();

        UserRef userRef = new UserRef(system.deadLetters(), "user");
        Messages.JoinChatroom request = new Messages.JoinChatroom(userRef);
        chatroom.joinChatroom(request);

        assertEquals(chatroom.joinedUsers.get(0), userRef);
    }

    @Test
    public void testShouldSendHistoryWhenUserJoin() {
        new JavaTestKit(system) {{
            //Given
            Props props = Props.create(Chatroom.class);
            TestActorRef<Chatroom> ref = TestActorRef.create(system, props);
            Chatroom chatroom = ref.underlyingActor();
            Messages.PostToChatroom msg = new Messages.PostToChatroom("test", "user");
            chatroom.chatHistory.add(msg);

            //When
            UserRef userRef = new UserRef(system.deadLetters(), "user");
            Messages.JoinChatroom request = new Messages.JoinChatroom(userRef);
            ref.tell(request, getRef());

            //Then
            List expected = new ArrayList<Messages.PostToChatroom>();
            expected.add(msg);
            expectMsgEquals(duration("1 second"), expected);
        }};
    }

    @Test
    public void testShouldSendUpdateWhenUserPosts() {
        //Given
        Props props = Props.create(Chatroom.class);
        TestActorRef<Chatroom> ref = TestActorRef.create(system, props);
        Chatroom chatroom = ref.underlyingActor();

        final TestProbe probe = new TestProbe(system);
        UserRef userRef = new UserRef(probe.ref(), "user");
        chatroom.joinChatroom(new Messages.JoinChatroom(userRef));

        //When
        Messages.PostToChatroom msg = new Messages.PostToChatroom("test", "user");
        ref.tell(msg, probe.ref());

        //Then
        probe.expectMsg(msg);
    }
}