package fr.ustephan.codekata.datamunging.soccer;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class SoccerTeamStatTest {

    @Test
    public void shouldReturnSoccer() {
        final String line = "    1. Arsenal         38    26   9   3    79  -  36    87       ";
        assertNotNull(SoccerTeamStat.fromLine(line));
    }

    @Test
    public void shouldReturnNullWithIncorrectLine() {
        final String line = " jserkjgndkrnklsnk seorgjieo'nks";
        assertNull(SoccerTeamStat.fromLine(line));
    }

    @Test
    public void shouldReturnNullWithEmptyLine() {
        final String line = "";
        assertNull(SoccerTeamStat.fromLine(line));
    }
}