package com.javaeeeee.dwstart.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class XmemeRequest {
    private String name;
    private String url;
    private String caption;

    public XmemeRequest() {
        // Jackson deserialization
    }


}
