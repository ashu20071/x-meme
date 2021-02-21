package com.javaeeeee.dwstart;

import com.javaeeeee.dwstart.resources.XmemeResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


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
        bootstrap.addBundle(new AssetsBundle("/assets", "/html", "index.html","html"));
    }

    @Override
    public void run(final DWGettingStartedConfiguration configuration,
                    final Environment environment) {

        final XmemeResource resource = new XmemeResource(
                configuration.getXmemeName(),
                configuration.getXmemeCaption(),
                configuration.getXmemeUrl()
        );

        environment.jersey().register(resource);
        environment.healthChecks().register("DWGettingStartedHealthCheck", new DWGettingStartedHealthCheck(configuration));
    }
}
