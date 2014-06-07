package com.poolborges.example;

/**
 *
 * @author PauloBorges
 * This auxiliary class supports the specification that has the return types defined. 
 */
public class WeatherReading {
    
    private float temperature;
    private float rain;

    public WeatherReading(float temperature, float rain) {
        this.temperature = temperature;
        this.rain = rain;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    @Override
    public String toString() {
        return "{Temp:"+temperature+", rain:"+rain+"}";
    }
    
    
}
