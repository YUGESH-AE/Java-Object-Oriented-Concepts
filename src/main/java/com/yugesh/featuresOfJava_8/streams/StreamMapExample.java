package com.yugesh.featuresOfJava_8.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class StreamMapExample {

    static void main() {

        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "yugesh", 989898998, 32));
        list.add(new Student(2, "Abilash", 876876876, 26));
        list.add(new Student(3, "Jatin", 231321, 20));
        list.add(new Student(4, "Rakesh", 9989, 18));
        list.add(new Student(5, "Soumik", 32242352, 19));
        list.add(new Student(6, "Suresh", 39900909, 30));
        list.add(new Student(7, "Ramesh", 868668686, 34));
        list.add(new Student(8, "Sundar", 9090909, 21));
        list.add(new Student(9, "shiva", 222222, 20));

        List<String> name =
                list.stream()
                        .filter(s -> s.getAge() > 25)
                        .map(Student::getName)
                        .limit(2)
                        .toList();
        System.out.println(name);

    }

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    static class Student {
        private int id;
        private String name;
        private long mobileNo;
        private int age;
    }
}
