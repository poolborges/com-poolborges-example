package com.poolborges.example.spi.weather;

import com.poolborges.example.WeatherReading;

/**
 *
 * @author PauloBorges
 * This class defines the SPI specification for weather service. 
 * It has two overloaded methods that define the behavior: 
 * retrieving the weather reading given the city name or zip code
 */
public interface WeatherProvider {
    
    public WeatherReading getCurrentWeather(String city);
    public WeatherReading getCurrentWeather(int zipCode);
}
