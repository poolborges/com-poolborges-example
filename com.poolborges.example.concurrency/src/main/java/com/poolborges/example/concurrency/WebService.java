/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.concurrency;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Borges
 */
public class WebService {

    public static void main(String[] a) {
        try {
            Executor pool = Executors.newFixedThreadPool(5);
            ServerSocket socket = new ServerSocket(8080);
            while (true) {
                final Socket conn = socket.accept();
                final Runnable task = new Runnable() {
                    public void run() {
                        new Handler().process(conn);
                    }
                };
                pool.execute(task);
            }
        } catch (IOException ex) {
            Logger.getLogger(WebService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class Handler {

    void process(Socket conn) {
        System.out.println(conn);
    }
}