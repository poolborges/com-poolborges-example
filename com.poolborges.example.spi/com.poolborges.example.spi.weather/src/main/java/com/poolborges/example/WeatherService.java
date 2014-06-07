package com.poolborges.example;

import java.util.ServiceLoader;
import com.poolborges.example.spi.weather.WeatherProvider;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/**
 * WeatherService (Singleton pattern)
 * @author PauloBorges
 */
public final class WeatherService {

    private final ServiceLoader<WeatherProvider> loader;

    private static WeatherService instance = null;

    protected WeatherService() {
        loader = ServiceLoader.load(WeatherProvider.class);
    }

    public static WeatherService getInstance() {
        if (instance == null) {
            instance = new WeatherService();
        }
        return instance;
    }

    public WeatherReading getWeather(String city) {
        WeatherReading weatherInfo = null;
        try {
            Iterator<WeatherProvider> providers = loader.iterator();

            while (weatherInfo == null && providers.hasNext()) {
                WeatherProvider weatherProvider = providers.next();
                weatherInfo = weatherProvider.getCurrentWeather(city);
            }
        } catch (ServiceConfigurationError serviceError) {
            weatherInfo = null;
            serviceError.printStackTrace();
        }
        return weatherInfo;
    }

    public WeatherReading getWeather(int zipCode) {
        WeatherReading weatherInfo = null;
        try {
            Iterator<WeatherProvider> providers = loader.iterator();

            while (weatherInfo == null && providers.hasNext()) {
                WeatherProvider weatherProvider = providers.next();
                weatherInfo = weatherProvider.getCurrentWeather(zipCode);
            }
        } catch (ServiceConfigurationError serviceError) {
            weatherInfo = null;
            serviceError.printStackTrace();
        }
        return weatherInfo;
    }
}
