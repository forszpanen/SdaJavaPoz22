package com.forszpaniak;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


public class PanTadeusz {

    public static void main(String[] args) throws IOException, URISyntaxException {
        //Path currentDir = Path.of(".");
        //System.out.println(currentDir.toAbsolutePath());
        URI uri = PanTadeusz.class.getClassLoader().getResource("pan-tadeusz.txt").toURI();
        Path path = Path.of(uri);
        String panTadeusz = Files.readString(path);
        String[] words = panTadeusz.split("[ \n.,:»«!?\\-;…]+");

        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (word.length() <= 3) {
                continue;
            }
            Integer counter = count.getOrDefault(word, 0);
            counter++;
            count.put(word, counter);
        }

        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        };
        TreeSet<Map.Entry<String, Integer>> entries = new TreeSet<>(comparator);
        entries.addAll(count.entrySet());
        System.out.println(entries);

        int numberOf = 0;
        for (Map.Entry<String, Integer> sortedEntry : entries) {
            numberOf++;
            if (numberOf == 5) {
                break;
            }
            System.out.println(sortedEntry);
        }

        System.out.println("OK");
    }
}