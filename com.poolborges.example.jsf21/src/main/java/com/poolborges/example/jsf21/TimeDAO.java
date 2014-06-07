/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jsf21;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Borges
 */
public class TimeDAO {
    
    public List<Time> listaTodos(){
        List<Time> listaTime = new ArrayList<Time>();
        for (int i = 1; i < 10; i++) {
            listaTime.add(new Time(i, "Nome:"+i, 5*i));
        }
        
        return listaTime;
    }
}
