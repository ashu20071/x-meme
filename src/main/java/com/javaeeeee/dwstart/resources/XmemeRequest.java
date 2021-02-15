package com.javaeeeee.dwstart.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class XmemeRequest {
    private String name;
    private String url;
    private String caption;

    public XmemeRequest() {
        // Jackson deserialization
    }

    public XmemeRequest(String name, String url, String caption) {
        this.name = name;
        this.url = url;;
        this.caption = caption;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getUrl() {
        return url;
    }

    @JsonProperty
    public String getCaption() {
        return caption;
    }
}
