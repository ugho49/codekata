package fr.ustephan.codekata.datamunging.soccer;

class SoccerTeamStat {

    private final String teamName;
    private final int forGoals;
    private final int againstGoals;

    private SoccerTeamStat(final String teamName, final int forGoals, final int againstGoals) {
        this.teamName = teamName;
        this.forGoals = forGoals;
        this.againstGoals = againstGoals;
    }

    String getTeamName() {
        return teamName;
    }

    int getDifferenceInForAndAgainstGoals() {
        return Math.abs(forGoals - againstGoals);
    }

    static SoccerTeamStat fromLine(final String line) {
        try {
            final String name = line.substring(7, 23).trim();
            final int forGoals = Integer.parseInt(line.substring(43, 45).trim());
            final int againstGoals = Integer.parseInt(line.substring(50, 52).trim());
            return new SoccerTeamStat(name, forGoals, againstGoals);
        } catch (Exception e) {
            System.out.println("ignore line : " + line);
            return null;
        }
    }
}
