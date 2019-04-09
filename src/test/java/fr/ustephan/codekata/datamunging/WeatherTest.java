package fr.ustephan.codekata.datamunging;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class WeatherTest {

    @Test
    public void shouldReturnWeather() {
        final String line = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";
        assertNotNull(Weather.fromLine(line));
    }

    @Test
    public void shouldReturnNullWithIncorrectLine() {
        final String line = " jserkjgndkrnklsnk seorgjieo'nks";
        assertNull(Weather.fromLine(line));
    }

    @Test
    public void shouldReturnNullWithEmptyLine() {
        final String line = "";
        assertNull(Weather.fromLine(line));
    }
}