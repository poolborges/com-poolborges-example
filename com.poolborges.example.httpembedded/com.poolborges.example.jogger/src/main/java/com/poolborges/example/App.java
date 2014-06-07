package com.poolborges.example;

import java.util.UUID;
import org.jogger.Jogger;
import org.jogger.JoggerServer;
import org.jogger.RouteHandler;
import org.jogger.http.Request;
import org.jogger.http.Response;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");
        App obj = new App();
        System.out.println("Unique ID : " + obj.generateUniqueKey());

        Jogger app = new Jogger();
        app.get("/", new RouteHandler() {
            @Override
            public void handle(Request request, Response response) {
                response.setHeader("Content-Type", "text/plain");
                response.write("<h1>Hello World Jogger</h1>");
            }
        });

        JoggerServer server = new JoggerServer(app);
        server.listen(5000);
        server.join();
    }

    public String generateUniqueKey() {

        String id = UUID.randomUUID().toString();
        return id;
    }

}
