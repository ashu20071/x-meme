package com.javaeeeee.dwstart.resources;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Builder
@RequiredArgsConstructor
@Getter
@Setter
public class DbClass {

    private final Map<Long, XmemeInfo> xMemes =  new HashMap<>();

    public Map<Long, XmemeInfo> getMemes() {
        return xMemes;
    }

    public void addMeme(XmemeInfo memeInfo) {
        xMemes.put(memeInfo.getMemeId(), memeInfo);
    }
}
