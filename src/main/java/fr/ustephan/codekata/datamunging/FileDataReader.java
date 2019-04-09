package fr.ustephan.codekata.datamunging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileDataReader {

    public static List<String> getLines(final File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            lines = Collections.emptyList();
        } finally {
            System.out.println("close buffer");
        }
        return lines;
    }
}
