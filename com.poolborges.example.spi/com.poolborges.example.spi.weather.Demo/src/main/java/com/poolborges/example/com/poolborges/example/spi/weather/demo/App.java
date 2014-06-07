package com.poolborges.example.com.poolborges.example.spi.weather.demo;

import com.poolborges.example.WeatherService;

/**
 * Hello world!
 *
 */
public class App 
{
    private static WeatherService weatherService;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        weatherService = WeatherService.getInstance();
        System.out.println(weatherService.getWeather(1));
    }
}
