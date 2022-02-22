package com.bbo.resource;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/secure")
public class SecureResource {

    @Claim(standard = Claims.preferred_username)
    String username;

    @RolesAllowed("Subscriber")
    @GET
    @Path("claim")
    public String getClaim() {
        System.out.println(username);
        return username;
    }

    @RolesAllowed("Not-Subscriber")
    @GET
    @Path("claimKO")
    public String getClaim403() {
        System.out.println(username);
        return username;
    }
}
