package com.poolborges.example.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;


 
public class JAXBDemo {
 
    public static void main(String[] args) throws Exception {
 
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
 
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        JAXBElement<Customer> jaxbElement = new JAXBElement<Customer>(new QName("customer"), Customer.class, Data.CUSTOMER);
        marshaller.marshal(jaxbElement, System.out);
    }
} 

