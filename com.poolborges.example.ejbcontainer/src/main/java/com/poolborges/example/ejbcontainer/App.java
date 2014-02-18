package com.poolborges.example.ejbcontainer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 * Hello world!
 *
 */
public class App {

    private static EJBContainer ejbContainer;
    private static Context ctx;

    public static void main(String[] args) throws NamingException {

/*
        http://pic.dhe.ibm.com/infocenter/wasinfo/v8r0/index.jsp?topic=%2Fcom.ibm.websphere.nd.doc%2Finfo%2Fae%2Fae%2Ftejb_dvemcontainer.html
        // Create a properties map to pass to the embeddable container:
        Map<String, Object> properties = new HashMap<String, Object>();
        // Specify that you want to use the WebSphere embeddable container:
        properties.put(EJBContainer.PROVIDER, "com.ibm.websphere.ejbcontainer.EmbeddableContainerProvider");
        // Create the container instance, passing it the properties map:
        EJBContainer ec = EJBContainer.createEJBContainer(properties);
        // Use the container context to look up a bean:
        //MyBeanIface bean = ec.getContext().lookup("java:global/MyEJBModule/MyBean!my.pkg.MyBeanIface");

        // Invoke a method on the bean instance:
        //bean.doStuff();
        
        // ...
        // Close the embeddable container:
        ec.close();
  */

        //https://netbeans.org/kb/docs/javaee/javaee-entapp-junit.html
        System.out.println("poolborges embeddable.EJBContainer");
        //properties.put(EJBContainer.MODULES, new File("target/classes"));
        //ejbContainer = EJBContainer.createEJBContainer(properties);
        ejbContainer = EJBContainer.createEJBContainer();
        ctx = ejbContainer.getContext();

        UserEJB userEJB = (UserEJB) ctx.lookup("java:global/classes/UserEJB");

        List<UserBean> users = userEJB.findAll();

        for (UserBean a : users) {
            System.out.println(a);
        }

        ejbContainer.close();
    }
}
