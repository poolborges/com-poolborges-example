package com.poolborges.example.ejbcontainer;

import javax.ejb.Stateless;

/**
 *
 * @author PauloBorges
 */
@Stateless
public class MathBean {
    public int addNumbers(int numberA, int numberB) {
        return numberA + numberB;
    }
}
