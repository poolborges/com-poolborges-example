/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.spring.dao;

import com.poolborges.example.spring.model.Customer;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PauloBorges
 */
@Repository
public class CustomerDAO extends AbstractJpaDAO<Customer, Long>{
    
}
