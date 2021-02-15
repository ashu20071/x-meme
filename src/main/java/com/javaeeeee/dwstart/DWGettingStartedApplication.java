package com.javaeeeee.dwstart;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaeeeee.dwstart.resources.DbClass;
import com.javaeeeee.dwstart.resources.XmemeResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.validation.constraints.NotNull;

public class DWGettingStartedApplication extends Application<DWGettingStartedConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DWGettingStartedApplication().run(args);
    }

    @Override
    public String getName() {
        return "DWGettingStarted";
    }

    @Override
    public void initialize(final Bootstrap<DWGettingStartedConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(new AssetsBundle("/assets/index", "/index", "index.js"));
        bootstrap.addBundle(new AssetsBundle("/assets/App.js", "/App", "App.js"));
    }

    @Override
    public void run(final DWGettingStartedConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        final XmemeResource resource = new XmemeResource(
                configuration.getName(),
                configuration.getCaption(),
                configuration.getUrl()
        );
        environment.jersey().setUrlPattern("/memes/http://localhost:8080/");
        environment.jersey().register(resource);
    }

}
