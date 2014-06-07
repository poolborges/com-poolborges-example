/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.springdata.repository;

import com.poolborges.example.springdata.domain.Address;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Borges
 */
public interface AddressRepository extends CrudRepository < Address, Long >, AddressRepositoryCustom {
}
