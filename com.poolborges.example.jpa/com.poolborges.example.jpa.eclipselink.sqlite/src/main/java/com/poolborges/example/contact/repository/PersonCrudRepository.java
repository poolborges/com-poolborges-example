package com.poolborges.example.contact.repository;

import com.poolborges.example.contact.domain.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepository extends CrudRepository< Person, Long> {

    @Query("select count(p) from Person p where p.lastName = ?1")
    public Long getLastNameCount(String lastName);
}
