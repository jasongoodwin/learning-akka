package com.akkademy;

import java.io.Serializable;

public class ParseArticle implements Serializable {
    public final String htmlBody;
    public ParseArticle(String url) {
        this.htmlBody = url;
    }
}
