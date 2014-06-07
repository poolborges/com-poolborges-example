package com.poolborges.example;

//import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*
         get(new Route("/hello") {
         @Override
         public Object handle(Request request, Response response) {
         return "Hello World!";
         }
         });
         */
        Spark.setPort(8090);
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                //response.body("<h1>Hello World Jogger</h1>");
                //return response;
                return "<h1>Hello World Jogger</h1>";
            }
        });
    }
}
