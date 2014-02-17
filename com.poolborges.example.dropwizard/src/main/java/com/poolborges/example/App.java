package com.poolborges.example;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws Exception {

        System.out.println("DropWizard Example!");

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    new BlogService().run(new String[]{"server"});
                } catch (Exception ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, "JanusRestService").start();
    }

    class JanusRest implements Runnable {

        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    }
}
