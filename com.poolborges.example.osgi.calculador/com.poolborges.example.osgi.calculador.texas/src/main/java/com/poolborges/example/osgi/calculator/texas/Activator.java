package com.poolborges.example.osgi.calculator.texas;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private BundleContext context;

    public void start(BundleContext context) throws Exception {
        this.context = context;

        System.out.println("calculator.texas Start");
    }

    public void stop(BundleContext context) throws Exception {
        
        System.out.println("calculator.texas Stop");
    }
}
