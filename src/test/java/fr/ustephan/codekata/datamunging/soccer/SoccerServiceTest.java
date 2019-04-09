package fr.ustephan.codekata.datamunging.soccer;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import static org.junit.Assert.*;

public class SoccerServiceTest {

    private final SoccerService soccerService;

    public SoccerServiceTest() throws FileNotFoundException {
        this.soccerService = new SoccerService(getFile());
    }

    @Test(expected=FileNotFoundException.class)
    public void shouldEmitAnExceptionIfFileNull() throws Exception {
        new SoccerService(null);
    }

    @Test(expected=FileNotFoundException.class)
    public void shouldEmitAnExceptionIfNotFile() throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final URL resource = classLoader.getResource("");
        new SoccerService(new File(resource.getFile()));
    }

    @Test
    public void shouldReturnTheDifferenceInForAndAgainstGoalsForArsenal() throws Exception {
        assertEquals(43, soccerService.getDifferenceInForAndAgainstGoalsForTeam("Arsenal"));
    }

    @Test(expected=Exception.class)
    public void shouldEmitAnExceptionIfTeamDontExist() throws Exception {
        soccerService.getDifferenceInForAndAgainstGoalsForTeam("Toto");
    }

    @Test
    public void shouldReturnTheNameOfTheTeamWithTheSmallestDifferenceInForAndAgainstGoals() {
        assertEquals("Aston_Villa", soccerService.getNameOfTeamWithTheSmallestDifferenceInForAndAgainstGoals());
    }

    private File getFile() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final URL resource = classLoader.getResource("football.dat");
        return new File(resource.getFile());
    }
}