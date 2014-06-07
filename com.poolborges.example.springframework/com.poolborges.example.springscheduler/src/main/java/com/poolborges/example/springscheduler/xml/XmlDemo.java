/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.springscheduler.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author PauloBorges
 */
public class XmlDemo {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("config.xml", XmlDemo.class);
    }
}