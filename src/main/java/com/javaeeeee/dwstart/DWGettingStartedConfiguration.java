package com.javaeeeee.dwstart;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class DWGettingStartedConfiguration extends Configuration  {

//    @Valid
//    @NotNull
    @JsonProperty
//    private final AssetsConfiguration assets = AssetsConfiguration.builder().build();

    //@NotEmpty
    private String name ="Some User";

    //@NotEmpty
    private String caption = "Some Caption";

    //@NotEmpty
    private String url = "Some URL";

    @JsonProperty
    public String getUrl() {
        return url;
    }

    @JsonProperty
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getCaption() {
        return caption;
    }

    @JsonProperty
    public void setCaption(String caption) {
        this.caption = caption;
    }

//    @Override
//    public AssetsConfiguration getAssetsConfiguration() {
//        return assets;
//    }
}
