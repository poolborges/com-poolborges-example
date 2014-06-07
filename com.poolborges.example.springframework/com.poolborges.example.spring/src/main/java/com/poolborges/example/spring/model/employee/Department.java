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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author PauloBorges
 */
@Entity
public class Department {
 
    @Id
    @Column(name="D_ID")
    private BigDecimal dId;
 
    private String name;
 
    @ManyToMany
    @JoinTable(name="DEPT_EMP", joinColumns = 
        @JoinColumn(name="D_ID", referencedColumnName = "D_ID"), 
            inverseJoinColumns = @JoinColumn(name="E_ID", 
                referencedColumnName = "E_ID"))
    private List<Employee> member;
 
}
