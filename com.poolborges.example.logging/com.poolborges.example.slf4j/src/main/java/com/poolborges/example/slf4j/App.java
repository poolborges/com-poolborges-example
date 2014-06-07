package com.poolborges.example.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger log = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
     log.info("Test Logging");
    }
}
