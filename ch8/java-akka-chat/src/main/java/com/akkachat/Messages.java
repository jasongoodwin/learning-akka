package com.akkachat;


public class Messages {
    static public class JoinChatroom {
        public final UserRef userRef;

        public JoinChatroom(UserRef userRef) {
            this.userRef = userRef;
        }
    }

    static public class PostToChatroom{
        public final String line, username;

        public PostToChatroom(String line, String username) {
            this.line = line;
            this.username = username;
        }
    }
}
