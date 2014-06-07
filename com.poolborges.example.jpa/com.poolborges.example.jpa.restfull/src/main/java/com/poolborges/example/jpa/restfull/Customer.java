package com.poolborges.example.jpa.restfull;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
 
@Entity
@NamedQuery(name = "findCustomerByCity", 
            query = "SELECT c " +
                    "FROM Customer c " +
                    "WHERE c.address.city = :city")
@XmlRootElement
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
 
    @Id
    private long id;
 
    @Column(name="FIRST_NAME")
    private String firstName;
 
    @Column(name="LAST_NAME")
    private String lastName;
 
    @OneToOne(mappedBy="customer", cascade={CascadeType.ALL})
    private Address address;
 
    @OneToMany(mappedBy="customer", cascade={CascadeType.ALL})
    private Set<PhoneNumber> phoneNumbers;
 
    public long getId() {
        return this.id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return this.firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return this.lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public Address getAddress() {
        return this.address;
    }
 
    public void setAddress(Address address) {
        this.address = address;
    }
 
    public Set<PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }
 
    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
 
}