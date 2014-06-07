/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.tomcat.embedded;



import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 *
 * @author PauloBorges
 */
public class  MyEmbeddedTomcat{

    public static void main(String[] args) {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(2525);
        String baseDir = "C:\\apache-tomcat-7.0.6\\webapps";
        try {
            tomcat.addWebapp(null, "", baseDir + "\\ROOT");
            tomcat.addWebapp(null, "/manager", baseDir + "\\manager");
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
