package fr.ustephan.codekata.datamunging;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

class FileDataReader {

    static List<String> getLines(final File file) {
        try {
            return Files.readAllLines(Paths.get(file.toURI()));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }
}
