package com.javaeeeee.dwstart;

import com.codahale.metrics.health.HealthCheck;
import com.javaeeeee.dwstart.resources.XmemeService;

public class DWGettingStartedHealthCheck extends HealthCheck {

    private static final String HEALTHY_MESSAGE = "The Dropwizard blog Service is healthy for read and write";
    private static final String UNHEALTHY_MESSAGE = "The Dropwizard blog Service is not healthy. ";

    private final XmemeService xmemeService;

    public DWGettingStartedHealthCheck(XmemeService xmemeService) {
        this.xmemeService = xmemeService;
    }

    @Override
    public Result check() {
        String mySqlHealthStatus = xmemeService.performHealthCheck();

        if (mySqlHealthStatus == null)
            return Result.healthy(HEALTHY_MESSAGE);
        else
            return Result.unhealthy(UNHEALTHY_MESSAGE , mySqlHealthStatus);
    }

}
