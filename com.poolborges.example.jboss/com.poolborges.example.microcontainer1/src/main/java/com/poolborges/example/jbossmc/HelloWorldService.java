package com.poolborges.example.jbossmc;

import org.jboss.system.ServiceMBeanSupport;

/**
 *
 * @author PauloBorges
 */
public class HelloWorldService extends ServiceMBeanSupport implements HelloWorldServiceMBean
{
   // Our message attribute
   private String message = "Sorry no message today";

   // Getters and Setters
   public String getMessage()
   {
      return message;
   }
   public void setMessage(String message)
   {
      this.message = message;
   }

   // The printMessage operation
   public void printMessage()
   {
      log.info(message);
   }

   // The lifecycle
   protected void startService() throws Exception
   {
      log.info("Starting with message=" + message);
   }
   protected void stopService() throws Exception
   {
      log.info("Stopping with message=" + message);
   }
}
