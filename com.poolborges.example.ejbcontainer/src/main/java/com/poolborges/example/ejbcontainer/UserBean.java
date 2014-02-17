/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.ejbcontainer;

/**
 *
 * @author Borges
 */
public class UserBean {

    private Long id;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "{id:" + id + ",firstName:'" + firstName 
                + "',lastName:'" + lastName +"'}";
    }
    
    
}
