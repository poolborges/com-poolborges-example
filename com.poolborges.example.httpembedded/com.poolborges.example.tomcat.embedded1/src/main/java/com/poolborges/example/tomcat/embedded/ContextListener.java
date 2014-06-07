package com.poolborges.example.tomcat.embedded;


import javax.servlet.ServletContextEvent; 
import javax.servlet.ServletContextListener;
 
//import com.atomikos.icatch.jta.UserTransactionManager; 

/**
 *
 * @author PauloBorges
 */
public class ContextListener implements ServletContextListener { 
 
    //private UserTransactionManager utm; 
 
    @Override
    public void contextInitialized(ServletContextEvent event) { 
        try { 
            //utm = new UserTransactionManager(); 
            //utm.init(); 
            System.out.println("contextInitialized:initialized transaction manager"); 
        } 
        catch (Exception ex) { 
            //utm = null; 
            throw new RuntimeException("contextInitialized: cannot initialize UserTransactionManager", ex); 
        } 
    } 
 
    @Override
    public void contextDestroyed(ServletContextEvent event) { 
        //if (utm != null) { 
        //    utm.close(); 
            System.out.println("contextInitialized: shut down transaction manager"); 
        //} 
    } 
} 
