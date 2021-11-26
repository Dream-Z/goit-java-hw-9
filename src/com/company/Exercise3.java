package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Exercise3 {
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> unsortedHashMap) {
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortedHashMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> sortedHashMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> sortedWordElement : list) {
            sortedHashMap.put(sortedWordElement.getKey(), sortedWordElement.getValue());
        }
        return sortedHashMap;
    }

    public void run() {
        HashMap<String, Integer> wordsNumber = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/words.txt"))) {
            String line = bufferedReader.readLine();

            while (line != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    boolean exist = wordsNumber.containsKey(word);
                    if (!exist) {
                        wordsNumber.put(word, 1);
                    } else {
                        wordsNumber.put(word, wordsNumber.get(word) + 1);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            System.out.format("There is exception: %s", e);
        }
        Map<String, Integer> wordsNumberSorted = sortByValue(wordsNumber);

        System.out.println("\nExercise3:");
        for (Map.Entry<String, Integer> entry : wordsNumberSorted.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

