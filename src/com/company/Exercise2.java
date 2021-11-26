package com.company;

import org.json.simple.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Exercise2 {
    public void run() {
        ArrayList<Object> people = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/user.txt"))) {
            String line = bufferedReader.readLine();

            int counter = 0;
            System.out.println("\nExercise2:");
            while (line != null) {
                if (counter > 0) {
                    String[] obj = line.split(" ");
                    String name = obj[0];
                    String age = obj[1];
                    jsonObject.put("name", name);
                    jsonObject.put("age", Integer.parseInt(age));
                    people.add(jsonObject);
                    System.out.printf("Name <%s> and age <%s> \n", name, age);
                }
                line = bufferedReader.readLine();
                counter++;
            }
        } catch (Exception e) {
            System.out.format("There is exception: %s", e);
        }

        try (OutputStreamWriter oos = new OutputStreamWriter(new FileOutputStream("resources/users.json"), StandardCharsets.UTF_8)) {
            oos.append(people.toString());
            System.out.println("File has been written");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
