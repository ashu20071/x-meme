package com.javaeeeee.dwstart.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class XmemeInfo {
    @JsonProperty
    private long xmemeId;
    @JsonProperty
    private String xmemeName;
    @JsonProperty
    private String xmemeCaption;
    @JsonProperty
    private String xmemeUrl;

    public XmemeInfo() {
        super();
    }

    public XmemeInfo(String xmemeName, String xmemeCaption, String xmemeUrl) {
        super();
        this.xmemeName = xmemeName;
        this.xmemeUrl = xmemeUrl;
        this.xmemeCaption = xmemeCaption;
    }

    public long getXmemeId() {
        return xmemeId;
    }

    public void setXmemeId(long xmemeId) {this.xmemeId = xmemeId; }

    public String getXmemeName() {
        return xmemeName;
    }

    public void setXmemeName(String xmemeName) {
        this.xmemeName = xmemeName;
    }

    public String getXmemeUrl() {
        return xmemeUrl;
    }

    public void setXmemeUrl(String xmemeUrl) {
        this.xmemeUrl = xmemeUrl;
    }

    public String getXmemeCaption() {
        return xmemeCaption;
    }

    public void setXmemeCaption(String xmemeCaption) {
        this.xmemeCaption = xmemeCaption;
    }
}
