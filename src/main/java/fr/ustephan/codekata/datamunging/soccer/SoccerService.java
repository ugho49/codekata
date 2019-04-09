package fr.ustephan.codekata.datamunging.soccer;

import fr.ustephan.codekata.datamunging.FileDataReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class SoccerService {

    private final File footballFile;

    SoccerService(final File footballFile) throws FileNotFoundException {
        if (footballFile == null || !footballFile.isFile()) {
            throw new FileNotFoundException("football file is null or not a file");
        }
        this.footballFile = footballFile;
    }

    private List<SoccerTeamStat> getTeamsStats() {
        final List<String> lines = FileDataReader.getLines(footballFile);
        // Remove first line
        lines.remove(0);
        return lines.stream()
                .map(SoccerTeamStat::fromLine)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    String getNameOfTeamWithTheSmallestDifferenceInForAndAgainstGoals() {
        return getTeamsStats().stream()
                .min(Comparator.comparingDouble(SoccerTeamStat::getDifferenceInForAndAgainstGoals))
                .map(SoccerTeamStat::getTeamName)
                .orElse(null);
    }

    int getDifferenceInForAndAgainstGoalsForTeam(final String teamName) throws Exception {
        return getTeamsStats().stream()
                .filter(t -> teamName.equalsIgnoreCase(t.getTeamName()))
                .map(SoccerTeamStat::getDifferenceInForAndAgainstGoals)
                .findFirst()
                .orElseThrow(Exception::new);
    }
}
