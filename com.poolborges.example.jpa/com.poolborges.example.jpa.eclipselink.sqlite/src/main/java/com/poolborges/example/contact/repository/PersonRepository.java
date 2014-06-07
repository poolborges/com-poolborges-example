package com.poolborges.example.contact.repository;

import com.poolborges.example.contact.domain.Person;
import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository < Person, Long > {
	public Person findOne(Long id);
}

