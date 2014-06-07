package com.poolborges.example.microcontainer;

import java.net.URL;
import org.jboss.dependency.spi.ControllerContext;
import org.jboss.kernel.plugins.bootstrap.basic.BasicBootstrap;
import org.jboss.kernel.plugins.deployment.xml.BasicXMLDeployer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Throwable
  {

    // Bootstrap.
    BasicBootstrap bootstrap = new BasicBootstrap();
    bootstrap.run();


    // Load the bean definitions.
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    URL url = cl.getResource("jboss-beans.xml");
    BasicXMLDeployer deployer = new BasicXMLDeployer( bootstrap.getKernel() );
    deployer.deploy( url );

    // Get the garage bean.
    ControllerContext context = bootstrap.getKernel().getController().getInstalledContext("myGarage");
    System.out.println( "I have a garage: "+context.getTarget());

    // Clean up.
    deployer.shutdown();

  }// main()
}
