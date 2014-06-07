/*
 * To change this template, choose Tools
 */
package com.poolborges.example.jaxb;

import javax.xml.bind.annotation.*;
 
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
 
    private String city;
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
 
    
}
