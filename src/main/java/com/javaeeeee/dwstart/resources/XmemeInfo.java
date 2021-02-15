package com.javaeeeee.dwstart.resources;

public class XmemeInfo {
    private final long memeId;
    private String name;
    private String url;
    private String caption;

    public XmemeInfo(long memeId, XmemeRequest xmemeRequest) {
        this.memeId = memeId;
        this.name = xmemeRequest.getName();
        this.url = xmemeRequest.getUrl();
        this.caption = xmemeRequest.getCaption();
    }

    public long getMemeId() {
        return memeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
