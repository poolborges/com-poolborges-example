package com.poolborges.example.springmvc.domain;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public User getForUsername(String username) {
        Query query = entityManager
                .createQuery("select u from User u where u.username = ?");
        query.setParameter(1, username);
        return (User) query.getSingleResult();
    }

}