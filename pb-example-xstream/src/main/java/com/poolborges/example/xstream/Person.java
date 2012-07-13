/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.xstream;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Borges
 */
public class Person {

    private String firstname;
    private String lastname;
    private PhoneNumber personalPhone;
    private PhoneNumber fax;
    private Collection<PhoneNumber> phones = new ArrayList<PhoneNumber>();
    // ... constructors and methods

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void addGenericPhone(PhoneNumber ph){
        this.phones.add(ph);
    }
    public Person(String firstname, String lastname, PhoneNumber phone, PhoneNumber fax) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.personalPhone = phone;
        this.fax = fax;
    }
    
    

    public PhoneNumber getFax() {
        return fax;
    }

    public void setFax(PhoneNumber fax) {
        this.fax = fax;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public PhoneNumber getPhone() {
        return personalPhone;
    }

    public void setPhone(PhoneNumber phone) {
        this.personalPhone = phone;
    }
    
}
