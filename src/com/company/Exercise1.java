package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise1 {
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/file.txt"))) {
            String pattern = "^\\(?([0-9]{3})\\)?[-.]?([0-9]{3})[-.]?([0-9]{4})$";
            String pattern2 = "^\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}";
            String line;
            System.out.println("Exercise1:");
            while ((line = br.readLine()) != null) {
                if (line.matches(pattern) || line.matches(pattern2)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.format("There is next exception: %s", e);
        }
    }
}

