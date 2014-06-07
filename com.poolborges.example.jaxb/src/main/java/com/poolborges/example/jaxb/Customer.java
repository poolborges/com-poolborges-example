/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jaxb;

import java.util.List;
import javax.xml.bind.annotation.*;
  
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
 
    private int id;
 
    @XmlElement(name="first-name")
    private String firstName;
 
    @XmlElement(name="last-name")
    private String lastName;
  
    private Address address;
 
    @XmlElement(name="phone-number")
    private List<PhoneNumber> phoneNumbers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    
    
 
}