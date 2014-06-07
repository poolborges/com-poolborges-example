package com.poolborges.example.springscheduler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
