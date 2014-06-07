/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jettison;

import com.poolborges.example.jaxb.Customer;
import java.io.*;
import javax.xml.bind.*;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.jettison.mapped.*;
  
public class MarshalDemo {
 
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
  
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Customer customer = (Customer) unmarshaller.unmarshal(new File("src/blog/json/jettison/input.xml"));
 
        Configuration config = new Configuration();
        MappedNamespaceConvention con = new MappedNamespaceConvention(config);
        Writer writer = new OutputStreamWriter(System.out);
        XMLStreamWriter xmlStreamWriter = new MappedXMLStreamWriter(con, writer);
 
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(customer, xmlStreamWriter);
    }
 
}
