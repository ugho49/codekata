package fr.ustephan.codekata.datamunging.weather;

import fr.ustephan.codekata.datamunging.FileDataReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class WeatherService {

    private final File weatherFile;

    WeatherService(final File weatherFile) throws FileNotFoundException {
        if (weatherFile == null || !weatherFile.isFile()) {
            throw new FileNotFoundException("weather file is null or not a file");
        }
        this.weatherFile = weatherFile;
    }

    private List<Weather> getDaysInfo() {
        final List<String> lines = FileDataReader.getLines(weatherFile);
        lines.remove(0);
        lines.remove(0);
        return lines.stream()
                .map(Weather::fromLine)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    double getTemperatureSpreadForDay(int day) throws Exception {
        return getDaysInfo().stream()
                .filter(w -> w.getDay() == day)
                .map(Weather::getTemperatureSpread)
                .findFirst()
                .orElseThrow(Exception::new);
    }

    int getDayWithSmalestTemperatureSpread() {
        return getDaysInfo().stream()
                .min(Comparator.comparingDouble(Weather::getTemperatureSpread))
                .map(Weather::getDay)
                .orElse(0);
    }

    int getDayWithHighestTemperatureSpread() {
        return getDaysInfo().stream()
                .max(Comparator.comparingDouble(Weather::getTemperatureSpread))
                .map(Weather::getDay)
                .orElse(0);
    }
}
