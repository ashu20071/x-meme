package com.javaeeeee.dwstart.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class XmemeRequest {
    private long id;

    private String content;

    public XmemeRequest() {
        // Jackson deserialization
    }

    public XmemeRequest(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
