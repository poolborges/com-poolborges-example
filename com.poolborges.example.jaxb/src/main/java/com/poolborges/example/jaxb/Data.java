/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jaxb;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PauloBorges
 */
public class Data {
 
    public final static Customer CUSTOMER;
 
    static {
        CUSTOMER = new Customer();
        CUSTOMER.setId(123);
        CUSTOMER.setFirstName("Jane Doe");
 
        Address address = new Address();
        address.setStreet("1 A Street");
        address.setCity("Any Town");
        CUSTOMER.setAddress(address);
 
        PhoneNumber workPhoneNumber = new PhoneNumber();
        workPhoneNumber.setType("work");
        workPhoneNumber.setNumber("555-WORK");
        //CUSTOMER.getPhoneNumbers().add(workPhoneNumber);
 
        PhoneNumber cellPhoneNumber = new PhoneNumber();
        cellPhoneNumber.setType("cell");
        cellPhoneNumber.setNumber("555-CELL");
        //CUSTOMER.getPhoneNumbers().add(cellPhoneNumber);
        
        List teList = new ArrayList<PhoneNumber>();
        teList.add(workPhoneNumber);
         teList.add(cellPhoneNumber);
        
        CUSTOMER.setPhoneNumbers(teList);
    }
 
}
