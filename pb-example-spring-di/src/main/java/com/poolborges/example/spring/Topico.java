/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.spring;

/**
 *
 * @author Borges
 */
public class Topico {
    
    private String topicoDia;

    public String getTopicoDia() {
        return topicoDia;
    }

    public void setTopicoDia(String topicoDia) {
        this.topicoDia = topicoDia;
    }
    
    @Override
    public String toString(){
        return "Topico do dia: "+this.topicoDia;
    }
}
