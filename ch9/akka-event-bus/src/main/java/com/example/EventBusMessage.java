package com.example;

public class EventBusMessage {
    public final String topic;
    public final String msg;

    public EventBusMessage(String topic, String msg) {
        this.topic = topic;
        this.msg = msg;
    }
}
