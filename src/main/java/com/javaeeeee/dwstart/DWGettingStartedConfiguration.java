package com.javaeeeee.dwstart;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;

public class DWGettingStartedConfiguration extends Configuration {

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
}
