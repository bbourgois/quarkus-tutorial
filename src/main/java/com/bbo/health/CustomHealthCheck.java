package com.bbo.health;

import io.smallrye.health.checks.UrlHealthCheck;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.HttpMethod;

@ApplicationScoped
public class CustomHealthCheck {

    @ConfigProperty(name = "com.bbo.repository.FruityViceService/mp-rest/url")
    String externalURL;

    @Readiness
    HealthCheck checkURL() {
        return new UrlHealthCheck(externalURL+"/api/fruit/Lemon")
                .name("ExternalURL health check").requestMethod(HttpMethod.GET).statusCode(200);
    }
}
