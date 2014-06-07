package com.poolborges.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/resource/greet/{username}")
public class GreetResource 
{

    @GET
    @Produces("text/plain")
    public String getUser(@PathParam("username") String userName) {
        return "Hello " + userName + "!";
    }
}
