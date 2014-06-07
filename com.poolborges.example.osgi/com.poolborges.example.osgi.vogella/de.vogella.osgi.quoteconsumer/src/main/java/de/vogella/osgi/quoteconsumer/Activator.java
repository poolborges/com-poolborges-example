package de.vogella.osgi.quoteconsumer;

import de.vogella.osgi.quote.IQuoteService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

    private BundleContext context;
    private IQuoteService service;

    public void start(BundleContext context) throws Exception {
        this.context = context;
        // Register directly with the service
        ServiceReference reference = context
                .getServiceReference(IQuoteService.class.getName());
        service = (IQuoteService) context.getService(reference);
        System.out.println("Quoteconsumer start: quote"+service.getQuote());
        System.out.println();
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Quoteconsumer stop quote"+service.getQuote());
    }

}
