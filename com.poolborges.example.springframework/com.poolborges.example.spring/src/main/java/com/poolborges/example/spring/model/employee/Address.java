/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.spring.model.employee;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author PauloBorges
 */
@Entity
public class Address {
 
    @Id
    @Column(name="E_ID", insertable=false, updatable=false)
    private BigDecimal eId;
 
    private String city;
 
    private String street;
 
    @OneToOne
    @JoinColumn(name="E_ID")
    private Employee resident;
 
}
