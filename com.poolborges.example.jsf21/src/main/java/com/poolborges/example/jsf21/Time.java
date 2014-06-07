package com.poolborges.example.jsf21;

/**
 *
 * @author Borges
 */
public class Time {

    private long id;
    private String nomeTime;
    private double probabilidade;

    public Time(long id, String nomeTime, double probabilidade) {
        this.id = id;
        this.nomeTime = nomeTime;
        this.probabilidade = probabilidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public double getProbabilidade() {
        return probabilidade;
    }

    public void setProbabilidade(double probabilidade) {
        this.probabilidade = probabilidade;
    }
}
