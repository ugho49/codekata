package fr.ustephan.codekata.datamunging.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WeatherTest {

    @Test
    void shouldReturnWeather() {
        final String line = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";
        assertThat(Weather.fromLine(line)).isNotNull();
    }

    @Test
    void shouldReturnNullWithIncorrectLine() {
        final String line = " jserkjgndkrnklsnk seorgjieo'nks";
        assertThat(Weather.fromLine(line)).isNull();
    }

    @Test
    void shouldReturnNullWithEmptyLine() {
        final String line = "";
        assertThat(Weather.fromLine(line)).isNull();
    }
}
