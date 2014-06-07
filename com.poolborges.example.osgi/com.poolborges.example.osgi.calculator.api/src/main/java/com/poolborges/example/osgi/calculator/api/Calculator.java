/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.osgi.calculator.api;

/**
 *
 * @author Borges
 */
public interface Calculator {
    
    public double soma(double num1, double num2);
    public double subtrair(double num1, double num2);
    public double multiplicar(double num1, double num2);
    public double dividir(double num1, double num2);
}
