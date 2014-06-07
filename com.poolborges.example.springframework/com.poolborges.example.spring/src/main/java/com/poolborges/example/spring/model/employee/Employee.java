/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.spring.model.employee;


import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author PauloBorges
 */
@Entity
public class Employee {
 
    @Id
    @Column(name="E_ID")
    private BigDecimal eId;
 
    private String name;
 
    @OneToOne(mappedBy="resident")
    private Address residence;
 
    @OneToMany(mappedBy="contact")
    private List<PhoneNumber> contactNumber;
 
    @ManyToMany(mappedBy="member")
    private List<Department> team;
 
}
