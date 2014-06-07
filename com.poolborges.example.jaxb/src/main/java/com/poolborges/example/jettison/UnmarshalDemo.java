/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jettison;

import com.poolborges.example.jaxb.Customer;
import javax.xml.bind.*;
import javax.xml.stream.XMLStreamReader;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.mapped.*;
 
public class UnmarshalDemo {
 
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
 
        JSONObject obj = new JSONObject("{\"customer\":{\"id\":123,\"first-name\":\"Jane\",\"last-name\":\"Doe\",\"address\":{\"street\":\"123 A Street\"},\"phone-number\":[{\"@type\":\"work\",\"$\":\"555-1111\"},{\"@type\":\"cell\",\"$\":\"555-2222\"}]}}");
        Configuration config = new Configuration();
        MappedNamespaceConvention con = new MappedNamespaceConvention(config);
        XMLStreamReader xmlStreamReader = new MappedXMLStreamReader(obj, con);
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Customer customer = (Customer) unmarshaller.unmarshal(xmlStreamReader);
 
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
    }
 
}