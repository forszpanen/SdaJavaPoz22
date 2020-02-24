package com.forszpaniak;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PanTadeuszJava8 {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("/", "home", "konrad", "pan-tadeusz.txt");
//        Path path = Path.of("C:", "Users", "konrad", "Pulpit", "pan-tadeusz.txt");
        String panTadeusz = Files.readString(path);
        String[] words = panTadeusz.split("[ \n.,:»«!?\\-;…]+");

        Stream.of(words)
                .filter(word -> word.length() > 3)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((Comparator) Map.Entry.comparingByValue().reversed())
                .limit(5)
                .forEach(System.out::println);

        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            if (word.length() <= 3) {
                continue;
            }
            Integer counter = count.getOrDefault(word, 0);
            counter++;
            count.put(word, counter);
        }
        Set<Map.Entry<String, Integer>> entries = count.entrySet();
        SortedSet<Map.Entry<String, Integer>> sortedEntries =
                new TreeSet<>(Map.Entry.<String, Integer>comparingByValue().reversed());
        sortedEntries.addAll(entries);
        int numberOf = 0;
        for (Map.Entry<String, Integer> sortedEntry : sortedEntries) {
            numberOf++;
            if (numberOf == 5) {
                break;
            }
            System.out.println(sortedEntry);
        }

    }

}
