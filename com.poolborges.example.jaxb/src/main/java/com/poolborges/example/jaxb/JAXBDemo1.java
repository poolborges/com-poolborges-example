/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;


 
public class JAXBDemo1 {
 
    public static void main(String[] args) throws Exception {
 
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
 
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(Data.CUSTOMER, System.out);
    }
}
