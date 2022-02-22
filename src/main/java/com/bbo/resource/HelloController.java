package com.bbo.resource;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping(path="/hello")
public class HelloController {


    @ConfigProperty(name = "greeting")
    String greeting;

    @GetMapping
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greeting;
    }
}