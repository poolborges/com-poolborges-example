/*
 * http://blog.bdoughan.com/2010/07/jpa-entities-to-xml-bidirectional.html
 */
package com.poolborges.example.spring;

import com.poolborges.example.spring.model.Customer;
import java.io.StringReader;
import java.io.StringWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author PauloBorges
 */
public class JpaToJaxb {

    public static void main(String[] args) throws JAXBException {

// Read customer from database
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("CustomerService");
        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class, (long) 1);

// Save customer to XML
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        Marshaller marshaller = jc.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.marshal(customer, writer);

// Load customer from XML 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader reader = new StringReader(writer.toString());
        Customer detachedCustomer =
                (Customer) unmarshaller.unmarshal(reader);
        detachedCustomer.setLastName("Jones");

// Persist customer to database
        Customer mergedCustomer = em.merge(detachedCustomer);
        em.getTransaction().begin();
        em.persist(mergedCustomer);
        em.getTransaction().commit();
        em.close();
    }
}
