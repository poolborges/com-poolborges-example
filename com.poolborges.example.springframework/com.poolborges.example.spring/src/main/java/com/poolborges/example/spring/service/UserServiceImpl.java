/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.spring.service;

import com.poolborges.example.spring.dao.UserDao;
import java.util.Iterator;

/**
 *
 * @author PauloBorges
 */
public class UserServiceImpl implements UserService{
    
    private UserDao userDao;
 
    public Iterator<String> getUsers()
    {
        return userDao.getUsers();
    }
 
    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }
}
