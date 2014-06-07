/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.spring;

import com.poolborges.example.spring.service.UserService;
import java.util.Iterator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author PauloBorges
 */
public class SpringUserServiceClient {
    private UserService userService;
 
    public SpringUserServiceClient()
    {
        //initialize the spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = (UserService) context.getBean("userService");
    }
 
    private void fetchUsers()
    {
        Iterator<String> users = userService.getUsers();
        while(users.hasNext())
        {
            System.out.println(users.next());
        }
    }
 
    public static void main(String[] args)
    {
        SpringUserServiceClient client = new SpringUserServiceClient();
        client.fetchUsers();
    }
}

/**
I think what dendroot mention is about the following code

ApplicationContext context = new ClassPathXmlApplicationContext(“resources/applicationContext.xml”);
userService = (UserService) context.getBean(“userService”);

Your code is tight coupling to Spring, suggest to use Spring AOP to pass in your userService implementation class
 */
