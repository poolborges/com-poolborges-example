package com.poolborges.example;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.UriBuilder;

public class LaunchApp {
/*
    private static int getPort(int defaultPort) {
        String port = System.getenv("JERSEY_HTTP_PORT");
        if (null != port) {
            try {
                return Integer.parseInt(port);
            } catch (NumberFormatException e) {
            }
        }
        return defaultPort;
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(getPort(9998)).build();
    }
    */

    //public static final URI BASE_URI = getBaseURI();
    public static final URI BASE_URI = URI.create("http://localhost:9998/jersey/");

    protected static SelectorThread startServer(){
        try {
            final Map<String, String> initParams = new HashMap<String, String>();
            
            initParams.put("com.sun.jersey.config.property.packages", "com.poolborges.example.resources");
            initParams.put("com.sun.jersey.config.feature.Trace", "true");
            initParams.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
            SelectorThread threadSelector = GrizzlyWebContainerFactory.create(BASE_URI, initParams);
            return threadSelector;
        } catch (IOException ex) {
            Logger.getLogger(LaunchApp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void main(String[] args){

        //Create and fire up an HTTP server
        //ResourceConfig rc = new PackagesResourceConfig("com.kotancode.samples");
        //HttpServer server = GrizzlyServerFactory.createHttpServer("http://localhost:9999", rc);
       
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    System.out.println("Grizzly starting http at: "+BASE_URI.toURL());
                    SelectorThread threadSelector = startServer();
                    //System.in.read();
                    //System.exit(0);
                    threadSelector.enableMonitoring();
                    //threadSelector.stopEndpoint();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(LaunchApp.class.getName()).log(Level.SEVERE, "Server not started", ex);
                } catch (IOException ex) {
                    Logger.getLogger(LaunchApp.class.getName()).log(Level.SEVERE, "Server problem", ex);
                }
            }
        }).start();
    }
}
