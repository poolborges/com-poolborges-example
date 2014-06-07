package de.vogella.osgi.quoteservice.internal;

import de.vogella.osgi.quote.IQuoteService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    IQuoteService service;
    public void start(BundleContext context) throws Exception {
        service = new QuoteService();
        // Third parameter is a hashmap which allows to configure the service
        // Not required in this example
        context.registerService(IQuoteService.class.getName(), service, null);
        System.out.println("IQuoteService is registered");
    }

    public void stop(BundleContext context) throws Exception {
    }

}
