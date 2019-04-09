package fr.ustephan.codekata.datamunging;

class Weather {
    private final int day;
    private final double max;
    private final double min;

    private Weather(int day, double max, double min) {
        this.day = day;
        this.max = max;
        this.min = min;
    }

    int getDay() {
        return day;
    }

    double getTemperatureSpread() {
        return Math.abs(max - min);
    }

    static Weather fromLine(final String line) {
        try {
            final int day = Integer.parseInt(line.substring(0, 4).trim());
            final double max = Double.parseDouble(line.substring(6, 8).trim());
            final double min = Double.parseDouble(line.substring(12, 14).trim());
            return new Weather(day, max, min);
        } catch (Exception e) {
            System.out.println("ignore line : " + line);
            return null;
        }
    }
}
