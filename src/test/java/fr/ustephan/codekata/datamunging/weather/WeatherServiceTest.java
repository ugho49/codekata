package fr.ustephan.codekata.datamunging.weather;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WeatherServiceTest {

    private final WeatherService weatherService;

    WeatherServiceTest() throws FileNotFoundException {
        this.weatherService = new WeatherService(getFile());
    }

    @Test
    void shouldReturnTemperatureSpreadOfDayOne() throws Exception {
        assertThat(weatherService.getTemperatureSpreadForDay(1)).isEqualTo(29d);
    }

    @Test
    void shouldEmitAnExceptionIfFileNull() {
        assertThatThrownBy(() -> new WeatherService(null)).isInstanceOf(FileNotFoundException.class);
    }

    @Test
    void shouldEmitAnExceptionIfNotFile() {
        assertThatThrownBy(() -> {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            final URL resource = classLoader.getResource("");
            new WeatherService(new File(resource.getFile()));
        }).isInstanceOf(FileNotFoundException.class);
    }

    @Test
    void shouldEmitExceptionIfDayIsNotCorrect() {
        assertThatThrownBy(() -> weatherService.getTemperatureSpreadForDay(40)).isInstanceOf(Exception.class);
    }

    @Test
    void shouldReturnDayNumberWithHighestTemperatureSpread() {
        assertThat(weatherService.getDayWithHighestTemperatureSpread()).isEqualTo(9);
    }

    @Test
    void shouldReturnDayNumberWithSmalestTemperatureSpread() {
        assertThat(weatherService.getDayWithSmalestTemperatureSpread()).isEqualTo(14);
    }

    private File getFile() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final URL resource = classLoader.getResource("weather.dat");
        return new File(resource.getFile());
    }
}
