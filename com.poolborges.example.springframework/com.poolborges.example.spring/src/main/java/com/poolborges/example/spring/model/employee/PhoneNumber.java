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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PauloBorges
 */
@Entity
@Table(name="PHONE_NUMBER")
public class PhoneNumber {
 
    @Id
    @Column(name="P_ID")
    private BigDecimal pId;
 
    @ManyToOne
    @JoinColumn(name="E_ID", referencedColumnName = "E_ID")
    private Employee contact;
 
    private String num;
 
}
