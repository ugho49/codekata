package fr.ustephan.codekata.datamunging.weather;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class WeatherServiceTest {

    private final WeatherService weatherService;

    public WeatherServiceTest() throws FileNotFoundException {
        this.weatherService = new WeatherService(getFile());
    }

    @Test
    public void shouldReturnTemperatureSpreadOfDayOne() throws Exception {
        assertEquals(29d, weatherService.getTemperatureSpreadForDay(1), 0);
    }

    @Test(expected=FileNotFoundException.class)
    public void shouldEmitAnExceptionIfFileNull() throws Exception {
        new WeatherService(null);
    }

    @Test(expected=FileNotFoundException.class)
    public void shouldEmitAnExceptionIfNotFile() throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final URL resource = classLoader.getResource("");
        new WeatherService(new File(resource.getFile()));
    }

    @Test(expected=Exception.class)
    public void shouldEmitExceptionIfDayIsNotCorrect() throws Exception {
        weatherService.getTemperatureSpreadForDay(40);
    }

    @Test
    public void shouldReturnDayNumberWithHighestTemperatureSpread() {
        assertEquals(9, weatherService.getDayWithHighestTemperatureSpread());
    }

    @Test
    public void shouldReturnDayNumberWithSmalestTemperatureSpread() {
        assertEquals(14, weatherService.getDayWithSmalestTemperatureSpread());
    }

    private File getFile() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final URL resource = classLoader.getResource("weather.dat");
        return new File(resource.getFile());
    }
}