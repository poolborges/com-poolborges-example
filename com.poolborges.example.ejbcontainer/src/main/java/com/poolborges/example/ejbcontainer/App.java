package com.poolborges.example.ejbcontainer;

import java.io.File;
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
        //Map properties = new HashMap();
        //properties.put(EJBContainer.MODULES, new File("target/classes"));
        //ejbContainer = EJBContainer.createEJBContainer(properties);

        System.out.println("Hello World!");
        ejbContainer = EJBContainer.createEJBContainer();
        ctx = ejbContainer.getContext();

        UserEJB userEJB = (UserEJB) ctx.lookup("java:global/classes/UserEJB");

        List<UserBean> users = userEJB.findAll();
        
        for(UserBean a: users)
            System.out.println(a);
        
         ejbContainer.close();
    }
}
