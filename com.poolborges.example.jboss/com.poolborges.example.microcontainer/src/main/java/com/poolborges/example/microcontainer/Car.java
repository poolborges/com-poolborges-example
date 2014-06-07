/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.microcontainer;

/**
 *
 * @author PauloBorges
 */
public class Car {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int litresOfFuel;

    public int getLitresOfFuel() {
        return litresOfFuel;
    }

    public void setLitresOfFuel(int litresOfFuel) {
        this.litresOfFuel = litresOfFuel;
    }

    public Car() {
    }

    public Car(String name, int litres) {
        this.name = name;
        this.litresOfFuel = litres;
    }

    public String toString() {
        return "Car \"" + this.name + "\"";
    }
}
