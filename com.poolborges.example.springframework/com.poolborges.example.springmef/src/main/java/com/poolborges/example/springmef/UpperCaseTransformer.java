/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.springmef;

/**
 *
 * @author Borges
 */
public class UpperCaseTransformer implements ITransformer{
    
    public String getName() {
        return "Upper Case Transformer";
    }

    public String Transform(String text) {
        return text.toUpperCase();
    }
}
