/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.springdata.service;

import com.poolborges.example.springdata.domain.Product;
import com.poolborges.example.springdata.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Borges
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(Long id) {
       return productRepository.findOne(id);
    }

    public void saveProduct(Product p) {
        productRepository.save(p);
    }

    public void deleteProduct(Product p) {
        productRepository.delete(p);
    }
}
