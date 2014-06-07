package com.poolborges.example.osgi.calculator.texas;

import com.poolborges.example.osgi.calculator.api.Calculator;
import java.util.Properties;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private BundleContext context;

    public void start(BundleContext context) throws Exception {
        this.context = context;
        
        Calculator cal = new TexasCalculator();
        Properties props = new Properties();
        props.put("CALCULATOR", "TEXAS320");
        this.context.registerService(Calculator.class.getName(), cal, props);
    }

    public void stop(BundleContext context) throws Exception {
        // TODO add deactivation code here
    }
}
