package com.javaeeeee.dwstart;

import com.codahale.metrics.health.HealthCheck;

public class DWGettingStartedHealthCheck extends HealthCheck {

    private final String xmemeUrl;

    public DWGettingStartedHealthCheck(DWGettingStartedConfiguration dwGettingStartedConfiguration) {
        this.xmemeUrl = dwGettingStartedConfiguration.getXmemeUrl();
    }

    @Override
    protected Result check() throws Exception {
        if (!xmemeUrl.equals("xmeme.png"))
            return Result.unhealthy("URL is incorrect");
        return Result.healthy();
    }
}
