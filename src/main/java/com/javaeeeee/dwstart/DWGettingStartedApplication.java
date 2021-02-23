package com.javaeeeee.dwstart;

import com.javaeeeee.dwstart.resources.XmemeResource;
import com.javaeeeee.dwstart.resources.XmemeService;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public class DWGettingStartedApplication extends Application<DWGettingStartedConfiguration> {

    private static final Logger logger = LoggerFactory.getLogger(DWGettingStartedApplication.class);
    private static final String SQL = "sql";
    private static final String DROPWIZARD_MYSQL_SERVICE = "Dropwizard Service";

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

        final DataSource dataSource =
                configuration.getDataSourceFactory().build(environment.metrics(), SQL);
        DBI dbi = new DBI(dataSource);

        // Register Health Check
        DWGettingStartedHealthCheck healthCheck =
                new DWGettingStartedHealthCheck(dbi.onDemand(XmemeService.class));
        environment.healthChecks().register(DROPWIZARD_MYSQL_SERVICE, healthCheck);
        logger.info("Registering RESTful API resources");

        // Register Xmeme Resource
        environment.jersey().register(new XmemeResource(dbi.onDemand(XmemeService.class)));
    }
}
