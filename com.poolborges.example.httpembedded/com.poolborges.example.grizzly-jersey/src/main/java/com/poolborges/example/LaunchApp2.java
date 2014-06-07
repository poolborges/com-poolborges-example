package com.poolborges.example;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ServerProperties;

/**
 *
 * @author PauloBorges
 */
public class LaunchApp2 {

    static final URI BASE_URI = URI.create("http://localhost:8080/jackson/");

    public static void main(String[] args) {
        try {
            System.out.println("JSON with Jackson Jersey Example App");

            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, createApp());

            System.out.println(String.format("Application started.%nHit enter to stop it..."));
            System.in.read();
            server.shutdownNow();
        } catch (IOException ex) {
            Logger.getLogger(LaunchApp2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ResourceConfig createApp() {
        return new MyApplication();
    }

    static class MyApplication extends ResourceConfig {

        public MyApplication() {
            packages("com.poolborges.example.resources;com.poolborges.example.services");
            //register(org.glassfish.jersey.server.filter.UriConnegFilter.class);
            //register(org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpContainerProvider.class);
            //property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
        }
    }
}
