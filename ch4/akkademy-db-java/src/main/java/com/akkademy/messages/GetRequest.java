package com.akkademy.messages;

import java.io.Serializable;

public class GetRequest implements Serializable, Request {
    public final String key;

    public GetRequest(String key) {
        this.key = key;
    }
}
