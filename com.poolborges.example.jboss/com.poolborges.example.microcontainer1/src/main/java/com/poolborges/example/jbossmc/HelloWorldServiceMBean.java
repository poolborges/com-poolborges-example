/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jbossmc;


import org.jboss.system.ServiceMBean;

/**
 *
 * @author PauloBorges
 */
public interface HelloWorldServiceMBean extends ServiceMBean
{
   // Configure getters and setters for the message attribute
   String getMessage();
   void setMessage(String message);
   
   // The print message operation
   void printMessage();
}
