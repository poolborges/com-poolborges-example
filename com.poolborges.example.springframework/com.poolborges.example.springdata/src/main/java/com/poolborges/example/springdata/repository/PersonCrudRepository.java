/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.springdata.repository;

import com.poolborges.example.springdata.domain.Person;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Borges
 */
public interface PersonCrudRepository extends CrudRepository<Person, Long> {

    public List<Person> findByLastName(String lastName);

    //Named Queries
    @Query("select count(p) from Person p where p.lastName = ?1")
    public Long getLastNameCount(String lastName);
}

/*
 save(S entity)	Saves a given entity
 save(Iterable entities)	Saves all the given entities
 findOne(ID id)	Retrieves an entity by its id
 exists(ID id)	Checks if a given entity exists
 findAll	Returns all the entities
 count	Returns the number of all the entities
 delete(ID id)	Deletes an entity with the given id
 delete(T entity)	Delets a given entity
 */
