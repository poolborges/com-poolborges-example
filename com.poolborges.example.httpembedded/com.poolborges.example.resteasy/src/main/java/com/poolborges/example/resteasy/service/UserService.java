/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.resteasy.service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author PauloBorges
 */
@Path("api/unit")
public class UserService {

    private static Hashtable<String, User> users = new Hashtable<String, User>();

    static {
        User user = new User();
        user.setFirstName("QAI");
        user.setLastName("Bar");
        user.setUserName("fbar");
        users.put("fbar", user);

        user = new User();
        user.setFirstName("Scott");
        user.setLastName("Tiger");
        user.setUserName("tiger");
        users.put("tiger", user);
    }

    @GET
    @Path("sayHello")
    public String sayHello() {
        return "Hello cruel world!";
    }

    @GET
    @Path("/users")
    @Produces("application/xml")
    public List<User> listUsers() {
        return new ArrayList<User>(users.values());
    }

    @GET
    @Produces("application/xml")
    @Path("/users/{username}")
    public User getUser(@PathParam("username") String userName) {
        return users.get(userName);
    }

    @GET
    @Produces("application/xml")
    @Path("/users/get")
    public User getUser2(@PathParam("username") String userName) {
        return users.get(userName);
    }
}