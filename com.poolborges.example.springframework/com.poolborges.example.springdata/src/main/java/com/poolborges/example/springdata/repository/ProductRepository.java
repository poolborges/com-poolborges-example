/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.springdata.repository;

import com.poolborges.example.springdata.domain.Product;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Borges
 */
public interface ProductRepository extends CrudRepository<Product, Long> {}
