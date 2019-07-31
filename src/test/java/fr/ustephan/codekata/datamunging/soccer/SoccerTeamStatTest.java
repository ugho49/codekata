package fr.ustephan.codekata.datamunging.soccer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SoccerTeamStatTest {

    @Test
    void shouldReturnSoccer() {
        final String line = "    1. Arsenal         38    26   9   3    79  -  36    87       ";
        assertThat(SoccerTeamStat.fromLine(line)).isNotNull();
    }

    @Test
    void shouldReturnNullWithIncorrectLine() {
        final String line = " jserkjgndkrnklsnk seorgjieo'nks";
        assertThat(SoccerTeamStat.fromLine(line)).isNull();
    }

    @Test
    void shouldReturnNullWithEmptyLine() {
        final String line = "";
        assertThat(SoccerTeamStat.fromLine(line)).isNull();
    }
}
