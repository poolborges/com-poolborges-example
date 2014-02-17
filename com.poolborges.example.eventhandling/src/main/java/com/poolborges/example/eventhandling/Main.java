/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.poolborges.example.eventhandling;

/**
 *
 * @author Borges
 */
public class Main {
 
    public static void main(String[] args) {
        NumberReader reader = new NumberReader();
        NumberReadListener listener = new NumberReadListenerImpl();
        NumberReaderLoggingAdaptor adaptor = new NumberReaderLoggingAdaptor();
        adaptor.addNumberReadListener(listener);
        reader.addNumberReadListener(adaptor);
        reader.start();
    }
}
