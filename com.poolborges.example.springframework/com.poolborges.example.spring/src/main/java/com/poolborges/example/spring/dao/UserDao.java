package com.poolborges.example.spring.dao;

import java.util.Iterator;

/**
 *
 * @author PauloBorges
 */
public interface UserDao {
    
    Iterator<String> getUsers();
}
