package com.poolborges.example.spring.dao;

import java.io.Serializable;

/**
 *
 * @author PauloBorges
 */
public abstract class AbstractHibernateDao<T, PK extends Serializable> implements GenericDao<T, PK>{

    
    private Class<T> type;

    public AbstractHibernateDao(Class<T> type) {
        this.type = type;
    }

    public void create(T o) {
        //return (PK) getSession().save(o);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public T read(PK id) {
        //return (T) getSession().get(type, id);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(T o) {
       //getSession().update(o);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(T o) {
       //getSession().delete(o);
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
