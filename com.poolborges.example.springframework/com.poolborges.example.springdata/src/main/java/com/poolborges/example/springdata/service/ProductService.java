/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.springdata.service;

import com.poolborges.example.springdata.domain.Product;

/**
 *
 * @author Borges
 */
public interface ProductService {

    public Product getProduct(Long id);

    public void saveProduct(Product p);

    public void deleteProduct(Product p);
}
