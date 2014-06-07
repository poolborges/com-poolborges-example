package com.poolborges.example.osgi.calculator.api;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        System.out.println("Start Calculator API");
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }

}
