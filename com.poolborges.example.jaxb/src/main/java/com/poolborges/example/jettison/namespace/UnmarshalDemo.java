/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jettison.namespace;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.mapped.Configuration;
import org.codehaus.jettison.mapped.MappedNamespaceConvention;
import org.codehaus.jettison.mapped.MappedXMLStreamReader;
 
public class UnmarshalDemo {
 
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
 
        JSONObject obj = new JSONObject("{\"customer\":{\"@id\":\"123\",\"prop.name\":\"Jane Doe\"}}");
        Configuration config = new Configuration();
        Map<String, String> xmlToJsonNamespaces = new HashMap<String,String>(1);
        xmlToJsonNamespaces.put("http://www.example.org/package", "");
        xmlToJsonNamespaces.put("http://www.example.org/property", "prop");
        config.setXmlToJsonNamespaces(xmlToJsonNamespaces);
        MappedNamespaceConvention con = new MappedNamespaceConvention(config);
        XMLStreamReader xmlStreamReader = new MappedXMLStreamReader(obj, con);
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Customer customer = (Customer) unmarshaller.unmarshal(xmlStreamReader);
 
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
    }
 
}