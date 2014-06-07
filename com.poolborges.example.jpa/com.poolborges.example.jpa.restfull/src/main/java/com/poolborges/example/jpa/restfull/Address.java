package com.poolborges.example.jpa.restfull;

import java.io.Serializable;
import javax.persistence.*;
import org.eclipse.persistence.oxm.annotations.XmlInverseReference;
 
@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id
    private long id;
 
    private String city;
 
    private String street;
 
    @OneToOne
    @PrimaryKeyJoinColumn
    private Customer customer;
 
    public long getId() {
        return this.id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getCity() {
        return this.city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public String getStreet() {
        return this.street;
    }
 
    public void setStreet(String street) {
        this.street = street;
    }
 
    @XmlInverseReference(mappedBy="address")
    public Customer getCustomer() {
        return customer;
    }
 
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
 
}
