package com.bbo.resource;


import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("api/users")
public class UserResource {

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("info")
    @RolesAllowed("Subscriber")
    public String getInfo() {
        return "Access for subject " + jwt.getName() + " is granted";
    }
}
