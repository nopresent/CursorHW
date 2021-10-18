package com.cursorhw.hw10;

import java.util.Comparator;
import java.util.stream.Stream;

public class MyStream {
    public static void main(String[] args) {

        Stream<Human> stream = Stream.of(
                new Human("Sonya", 10, Gender.FEMALE),
                new Human("Natasha", 18, Gender.FEMALE),
                new Human("Ernest", 26, Gender.MALE),
                new Human("Ivan Vasilevich", 69, Gender.MALE),
                new Human("Jessika", 21, Gender.FEMALE),
                new Human("Ognessa Pavlovna", 64, Gender.FEMALE)
        );

        stream.filter(x -> x.getAge() >= 18)
                .filter(x -> x.getAge() < 60)
                .sorted(Comparator.comparingInt(o -> o.getGender().toString().length()))
                .forEach(System.out::println);
    }
}

class Human {
    private String name;
    private Integer age;
    private Gender gender;

    public Human(String name, Integer age, Gender g) {
        this.name = name;
        this.age = age;
        this.gender = g;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "{" + name + " - " + gender + "}";
    }
}

enum Gender {
    MALE,
    FEMALE
}
