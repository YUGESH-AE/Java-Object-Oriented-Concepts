package com.yugesh.objectComparison;

public class Student implements Comparable<Student>{

    int rollNo;

    float marks;

    public Student(int rollNo, float marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        return (int) (this.marks-o.marks);
    }
}
