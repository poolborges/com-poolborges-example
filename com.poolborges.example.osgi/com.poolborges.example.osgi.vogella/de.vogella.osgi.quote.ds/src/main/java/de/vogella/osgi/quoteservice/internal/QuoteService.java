/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.vogella.osgi.quoteservice.internal;

import de.vogella.osgi.quote.IQuoteService;
import java.util.Random;

/**
 *
 * @author PauloBorges
 */
public class QuoteService implements IQuoteService {

    public String getQuote() {
        Random random = new Random();
        // Create a number between 0 and 2
        int nextInt = random.nextInt(3);
        switch (nextInt) {
            case 0:
                return "Tell them I said something";
            case 1:
                return "I feel better already";
            default:
                return "Hubba Bubba, Baby!";
        }
    }
}
