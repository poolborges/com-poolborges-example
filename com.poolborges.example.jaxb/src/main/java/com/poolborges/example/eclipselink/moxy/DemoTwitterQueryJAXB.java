/*
 * https://dev.twitter.com/docs/api/1/get/search
 */
package com.poolborges.example.eclipselink.moxy;

import java.util.Date; 
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
 
public class DemoTwitterQueryJAXB {
  
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(SearchResults.class);
  
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setProperty("eclipselink.media-type", "application/json");
        unmarshaller.setProperty("eclipselink.json.include-root", false);
        StreamSource source = new StreamSource("http://search.twitter.com/search.json?q=jaxb");
        JAXBElement<SearchResults> jaxbElement = unmarshaller.unmarshal(source, SearchResults.class);
  
        Result result = new Result();
        result.setCreatedAt(new Date());
        result.setFromUser("bdoughan");
        result.setText("You can now use EclipseLink JAXB (MOXy) with JSON :)");
        jaxbElement.getValue().getResults().add(result);
  
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("eclipselink.media-type", "application/json");
        marshaller.setProperty("eclipselink.json.include-root", false);
        marshaller.marshal(jaxbElement, System.out);
    }
  
}
