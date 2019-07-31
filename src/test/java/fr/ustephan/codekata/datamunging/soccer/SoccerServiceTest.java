package fr.ustephan.codekata.datamunging.soccer;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SoccerServiceTest {

    private final SoccerService soccerService;

    SoccerServiceTest() throws FileNotFoundException {
        this.soccerService = new SoccerService(getFile());
    }

    @Test
    void shouldEmitAnExceptionIfFileNull() {
        assertThatThrownBy(() -> new SoccerService(null)).isInstanceOf(FileNotFoundException.class);
    }

    @Test
    void shouldEmitAnExceptionIfNotFile() {
        assertThatThrownBy(() -> {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            final URL resource = classLoader.getResource("");
            new SoccerService(new File(resource.getFile()));
        }).isInstanceOf(FileNotFoundException.class);
    }

    @Test
    void shouldReturnTheDifferenceInForAndAgainstGoalsForArsenal() throws Exception {
        assertThat(soccerService.getDifferenceInForAndAgainstGoalsForTeam("Arsenal")).isEqualTo(43);
    }

    @Test
    void shouldEmitAnExceptionIfTeamDontExist() {
        assertThatThrownBy(() -> soccerService.getDifferenceInForAndAgainstGoalsForTeam("Toto"))
                .isInstanceOf(Exception.class);
    }

    @Test
    void shouldReturnTheNameOfTheTeamWithTheSmallestDifferenceInForAndAgainstGoals() {
        assertThat(soccerService.getNameOfTeamWithTheSmallestDifferenceInForAndAgainstGoals()).isEqualTo("Aston_Villa");
    }

    private File getFile() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final URL resource = classLoader.getResource("football.dat");
        return new File(resource.getFile());
    }
}
