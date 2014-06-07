/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.com.poolborges.example.jbossmsc;

import org.jboss.msc.service.AbstractService;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
/**
 *
 * @author PauloBorges
 */
public class HelloService extends AbstractService<String>
{

    @Override
    public void start(StartContext context) throws StartException {
        super.start(context);
        System.out.println("Iniciei");
    }

    
    
}
