package com.yugesh.oops.staticExample;


public class Human {

    static long population;
    int age;
    String name;
    int salary;
    boolean married;


    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population += 1;
    }

    public static void display() {
        System.out.println("Displaying");
    }

    static void main() {
        new Human(26, "com/yugesh", 70000, false);
        new Human(26, "Ram", 70000, false);
        System.out.println(Human.population);

    }
}
