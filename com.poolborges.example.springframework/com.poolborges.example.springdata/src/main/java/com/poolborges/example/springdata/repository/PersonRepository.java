package com.poolborges.example.springdata.repository;


import com.poolborges.example.springdata.domain.Person;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Borges
 */


public interface PersonRepository extends Repository < Person, Long > {
	public Person findOne(Long id);
}
