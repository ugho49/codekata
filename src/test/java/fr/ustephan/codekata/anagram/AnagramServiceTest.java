package fr.ustephan.codekata.anagram;

import fr.ustephan.codekata.datamunging.FileDataReader;

import java.io.File;
import java.net.URL;
import java.util.List;


public class AnagramServiceTest {

    private final List<String> words;
    private final AnagramService anagramService;

    public AnagramServiceTest() {
        words = FileDataReader.getLines(getFile());
        anagramService = new AnagramService(words);
    }

    private File getFile() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final URL resource = classLoader.getResource("wordlist.txt");
        return new File(resource.getFile());
    }
}