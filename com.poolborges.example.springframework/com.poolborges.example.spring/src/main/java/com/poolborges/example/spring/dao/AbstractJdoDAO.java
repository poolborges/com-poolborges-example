/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.spring.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PauloBorges
 */
public class AbstractJdoDAO<T, PK extends Serializable> implements GenericDao<T, PK> {

    @PersistenceContext
    EntityManager entityManager;
    

    public void create(T entity) {
        this.entityManager.persist(entity);
    }

    public T read(PK id) {
        Class<T> type = null;
        return this.entityManager.find(type, id);
    }

    public void update(T entity) {
        this.entityManager.merge(entity);
    }

    public void delete(final T persistentObject) {
        this.entityManager.remove(persistentObject);
    }
}
