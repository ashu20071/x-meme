package com.javaeeeee.dwstart;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;

public class DWGettingStartedConfiguration extends Configuration  {
    @NotEmpty
    private String xmemeName ="Some User";

    @NotEmpty
    private String xmemeCaption = "Some Caption";

    @NotEmpty
    private String xmemeUrl = "https://upload.wikimedia.org/wikipedia/en/a/ad/X_cover.png";

    @JsonProperty
    public String getXmemeUrl() {
        return xmemeUrl;
    }

    @JsonProperty
    public void setXmemeUrl(String xmemeUrl) {
        this.xmemeUrl = xmemeUrl;
    }

    @JsonProperty
    public String getXmemeName() {
        return xmemeName;
    }

    @JsonProperty
    public void setXmemeName(String xmemeName) {
        this.xmemeName = xmemeName;
    }

    @JsonProperty
    public String getXmemeCaption() {
        return xmemeCaption;
    }

    @JsonProperty
    public void setXmemeCaption(String xmemeCaption) {
        this.xmemeCaption = xmemeCaption;
    }

}
