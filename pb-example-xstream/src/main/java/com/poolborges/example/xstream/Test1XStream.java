package com.poolborges.example.xstream;

import com.thoughtworks.xstream.XStream;

/**
 * Hello world!
 *
 */
public class Test1XStream {

    public static void main(String[] args) {
        //Initializing XStream
        XStream xstream = new XStream();

        /**
         * to make the XML outputted by XStream more concise, you can create
         * aliases for your custom class names to XML element names. This is the
         * only type of mapping required to use XStream and even this is
         * optional
         */
        xstream.alias("person", Person.class);
        xstream.alias("phonenumber", PhoneNumber.class);

        //Serializing an object to XML
        Person joe = new Person("Paulo", "Borges");
        joe.setPhone(new PhoneNumber(123, "1234-456"));
        joe.setFax(new PhoneNumber(123, "9999-999"));
        
        String xml = xstream.toXML(joe);
        
        System.out.println(xml);
    }
}
