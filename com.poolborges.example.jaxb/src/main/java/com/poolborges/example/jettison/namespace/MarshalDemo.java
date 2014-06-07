/*
 * To change this template, choose Tools.
 */
package com.poolborges.example.jettison.namespace;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamWriter;
import org.codehaus.jettison.mapped.Configuration;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamWriter;
 
public class MarshalDemo {
 
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Customer customer = (Customer) unmarshaller.unmarshal(new File("src/blog/json/ns/input.xml"));
 
        Configuration config = new Configuration();
        Map<String, String> xmlToJsonNamespaces = new HashMap<String,String>(1);
        xmlToJsonNamespaces.put("http://www.example.org/package", "");
        xmlToJsonNamespaces.put("http://www.example.org/property", "prop");
        config.setXmlToJsonNamespaces(xmlToJsonNamespaces);
        MappedNamespaceConvention con = new MappedNamespaceConvention(config);
        Writer writer = new OutputStreamWriter(System.out);
        XMLStreamWriter xmlStreamWriter = new MappedXMLStreamWriter(con, writer);
 
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(customer, xmlStreamWriter);
    }
 
}