package com.poolborges.example.com.poolborges.example.jbossmsc;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.jboss.msc.service.AbstractService;
import org.jboss.msc.service.Service;
import org.jboss.msc.service.ServiceContainer;
import org.jboss.msc.service.ServiceName;

/**
 * Hello world!
 *
 */
public class App {

    //private static final int MAX_THREADS = ServerEnvironment.getBootstrapMaxThreads();
    private static int MAX_THREADS = 2;
    protected volatile ServiceContainer serviceContainer;
    private boolean shutdownOnTearDown;

    void init() {
        Logger.getLogger("").fine("Setting up test " + getClass());

        //serviceContainer = ServiceContainer.Factory.create();
        serviceContainer = ServiceContainer.Factory.create("jboss-as", MAX_THREADS, 30, TimeUnit.SECONDS);
        serviceContainer.addService(ServiceName.JBOSS, new HelloService());
        serviceContainer.dumpServices();
    }

    public static void main(String[] args) {
        App app = new App();
        app.init();
    }
}
