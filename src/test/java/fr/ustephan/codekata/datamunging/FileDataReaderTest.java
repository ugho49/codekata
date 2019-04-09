package fr.ustephan.codekata.datamunging;

import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FileDataReaderTest {

    @Test
    public void shouldNotBeEmpty() {
        assertNotEquals(true, FileDataReader.getLines(getFile()).isEmpty());
    }

    @Test
    public void shouldContainsLinesIfFileIsCorrect() {
        assertEquals(33, FileDataReader.getLines(getFile()).size());
    }

    @Test
    public void shouldContainsNothingIfFileIsIncorrect() {
        assertEquals(0, FileDataReader.getLines(new File("segrersersg")).size());
    }

    private File getFile() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final URL resource = classLoader.getResource("weather.dat");
        return new File(resource.getFile());
    }
}