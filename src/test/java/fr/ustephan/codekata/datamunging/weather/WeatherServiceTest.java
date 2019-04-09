package fr.ustephan.codekata.datamunging.weather;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class WeatherServiceTest {

    private WeatherService weatherData;

    public WeatherServiceTest() throws FileNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final URL resource = classLoader.getResource("weather.dat");
        if (resource == null) {
            throw new FileNotFoundException("No weather file in resources folder");
        }
        File weatherFile = new File(resource.getFile());
        weatherData = new WeatherService(weatherFile);
    }

    @Test
    public void shouldReturnTemperatureSpreadOfDayOne() throws Exception {
        assertEquals(29d, weatherData.getTemperatureSpreadForDay(1), 0);
    }

    @Test(expected=Exception.class)
    public void shouldEmitExceptionIfDayIsNotCorrect() throws Exception {
        weatherData.getTemperatureSpreadForDay(40);
    }

    @Test
    public void shouldReturnDayNumberWithHighestTemperatureSpread() {
        assertEquals(9, weatherData.getDayWithHighestTemperatureSpread());
    }

    @Test
    public void shouldReturnDayNumberWithSmalestTemperatureSpread() {
        assertEquals(14, weatherData.getDayWithSmalestTemperatureSpread());
    }

}