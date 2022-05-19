package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Dorota", "Dominika", "Bogusia", "Radosława", "Antoni", "Jarosław");

        List<User> userList = names.stream()
                .filter(user -> user.endsWith("a"))
                .map(string -> new User(string, new Random().nextInt(70)))
                .sorted(new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                })
                .collect(Collectors.toList());

        System.out.println(userList);
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        System.out.println("Tworzę usera " + name);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
