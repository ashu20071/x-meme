package com.javaeeeee.dwstart.resources;

import java.util.HashMap;
import java.util.Map;

public class DbClass {
    private final Map<Long, XmemeInfo> xMemes;

    public DbClass() {
        this.xMemes = new HashMap<>();
    }

    public Map<Long, XmemeInfo> getMemes() {
        return xMemes;
    }

    public void addMeme(XmemeInfo memeInfo) {
        xMemes.put(memeInfo.getMemeId(), memeInfo);
    }
}
