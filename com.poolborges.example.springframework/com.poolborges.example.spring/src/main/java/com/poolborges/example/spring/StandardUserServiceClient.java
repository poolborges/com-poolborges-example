/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.spring;

import com.poolborges.example.spring.dao.UserDao;
import com.poolborges.example.spring.dao.UserDaoImpl;
import com.poolborges.example.spring.service.UserServiceImpl;
import java.util.Iterator;

/**
 *
 * @author PauloBorges
 */
public class StandardUserServiceClient {
    
    private UserServiceImpl userService;
 
    public StandardUserServiceClient()
    {
        userService = new UserServiceImpl();
        UserDao userDao = new UserDaoImpl();
        userService.setUserDao(userDao);
    }
 
    private void fetchUsers()
    {
        Iterator<String> users = userService.getUsers();
        while (users.hasNext())
        {
            System.out.println(users.next());
        }
    }
 
    public static void main(String[] args)
    {
        StandardUserServiceClient client = new StandardUserServiceClient();
        client.fetchUsers();
    }
}
