/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong;

import com.mkyong.model.Customer;
import java.util.Date;
import java.util.Iterator;
import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

/**
 *
 * @author Borges
 */
public class App {

    public static void main(String args[]) {
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager pm = pmf.getPersistenceManager();

        Transaction tx = pm.currentTransaction();
        /* */
        try {
            tx.begin();
            Customer inv = new Customer();
            inv.setEmail("pool1@hotmail.com");
            inv.setName("pool");
            inv.setDate(new Date());
            pm.makePersistent(inv);
            tx.commit();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
        
        // Basic retrieving JDOUnit
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("Retrieving Customer");
            Extent e = pm.getExtent(Customer.class, true);
            Iterator iter = e.iterator();
            while (iter.hasNext())
            {
                Object obj = iter.next();
                System.out.println(">  " + obj);
            }
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
}
