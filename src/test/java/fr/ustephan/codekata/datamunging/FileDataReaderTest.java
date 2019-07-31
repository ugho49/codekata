package fr.ustephan.codekata.datamunging;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

class FileDataReaderTest {

    @Test
    void shouldNotBeEmpty() {
        assertThat(FileDataReader.getLines(getFile())).isNotEmpty();
    }

    @Test
    void shouldContainsLinesIfFileIsCorrect() {
        assertThat(FileDataReader.getLines(getFile())).hasSize(33);
    }

    @Test
    void shouldContainsNothingIfFileIsIncorrect() {
        assertThat(FileDataReader.getLines(new File("segrersersg"))).hasSize(0);
    }

    private File getFile() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final URL resource = classLoader.getResource("weather.dat");
        return new File(resource.getFile());
    }
}
