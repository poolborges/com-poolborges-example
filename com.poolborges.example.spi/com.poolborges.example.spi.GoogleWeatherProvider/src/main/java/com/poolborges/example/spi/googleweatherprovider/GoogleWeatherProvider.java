package com.poolborges.example.spi.googleweatherprovider;

import com.poolborges.example.spi.weather.WeatherProvider;
import com.poolborges.example.WeatherReading;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author PauloBorges
 */
public class GoogleWeatherProvider implements WeatherProvider{

    private final SortedMap<String, WeatherReading> cityMap;
    private final SortedMap<Integer, WeatherReading> zipMap;
    public GoogleWeatherProvider() {
        
        cityMap = new TreeMap<String, WeatherReading>();
        zipMap = new TreeMap<Integer, WeatherReading>();
        
        WeatherReading coim = new WeatherReading((float)19.5, (float)19.5);
        WeatherReading lx = new WeatherReading((float)19.5, (float)19.5);
        
        cityMap.put("lx", lx);
        cityMap.put("coim", coim);
        
        zipMap.put(1, lx);
        zipMap.put(2, coim);
    }

    
    public WeatherReading getCurrentWeather(String city) {
       return cityMap.get(city);
    }

    public WeatherReading getCurrentWeather(int zipCode) {
        return zipMap.get(zipCode);
    }
    
}
