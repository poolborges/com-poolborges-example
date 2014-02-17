package com.poolborges.example.eventhandling;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        NumberReader reader = new NumberReader();
        NumberReadListener listener = new NumberReadListenerImpl();
        reader.addNumberReadListener(listener);
        reader.start();
    }
}
