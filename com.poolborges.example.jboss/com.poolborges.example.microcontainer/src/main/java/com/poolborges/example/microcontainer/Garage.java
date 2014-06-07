/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.microcontainer;

/**
 *
 * @author PauloBorges
 */
public class Garage {

    private Car carInside;

    public Car getCarInside() {
        return carInside;
    }

    public void setCarInside(Car car) {
        this.carInside = car;
    }

    @Override
    public String toString() {
        return "Garage with a car: " + this.getCarInside();
    }
}
