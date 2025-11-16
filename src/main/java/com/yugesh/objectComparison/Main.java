package com.yugesh.objectComparison;

public class Main {

    static void main() {
        Student yugesh = new Student(212, 99.99f);
        Student rahul = new Student(67, 89.9f);

        if (yugesh.compareTo(rahul) > 0) {
            System.out.println("yugesh is gretaer");
        }
    }
}
