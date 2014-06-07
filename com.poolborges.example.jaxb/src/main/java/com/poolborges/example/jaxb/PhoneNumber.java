/*
 * To change this template, choose Tools
 */
package com.poolborges.example.jaxb;

import javax.xml.bind.annotation.*;
 
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneNumber {
 
    @XmlAttribute
    private String type;
 
    @XmlValue
    private String number;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
 
    
}
