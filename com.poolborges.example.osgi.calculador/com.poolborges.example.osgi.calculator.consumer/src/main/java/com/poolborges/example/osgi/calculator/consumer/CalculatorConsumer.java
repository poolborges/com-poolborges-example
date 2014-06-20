package com.poolborges.example.osgi.calculator.consumer;

import com.poolborges.example.osgi.calculator.api.Calculator;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
/**
 *
 * @author Borges
 */
public class CalculatorConsumer  implements BundleListener {

    Calculator calc;
    
    

    public void bundleChanged(BundleEvent be) {
        
        System.out.println("CalculatorConsumer.bundleChanged: "+be.toString() +" - "+ be.getType());
    }
    
    public double formula()
    {
        return calc.dividir(50, 3);
    }
    
    /**
     * Binds the Calculator service to this component. Called by OSGi-DS.
     * 
     * @param service
     */
    protected void bindCalculator(Calculator service) {
        calc = service;
        calc.dividir(100, 2);
        
        System.out.println("CalculatorConsumer.bindCalculator: "+this.calc.dividir(4, 2));
    }
    
    /**
     * Unbinds the Calculator service from this component. Called by OSGi-DS.
     * 
     * @param service
     */
    protected void unbindCalculator(Calculator service) {
        // unregister the servlet from the http service
        System.out.println("CalculatorConsumer.unbindCalculator: "+this.calc.multiplicar(3, 3));
    }
    
}
