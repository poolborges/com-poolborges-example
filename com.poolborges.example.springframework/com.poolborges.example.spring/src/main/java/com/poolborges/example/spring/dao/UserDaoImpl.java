/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.spring.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author PauloBorges
 */
public class UserDaoImpl  implements UserDao{
    
    public Iterator<String> getUsers()
    {
        List<String> users = new ArrayList<String>();
        users.add("Gavin King");
        users.add("Geertjan");
        users.add("Mike Keith");
        users.add("James");
        return users.iterator();
    }
}
