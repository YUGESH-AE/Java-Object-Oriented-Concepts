package com.yugesh.dsa.problems.streams.AdvancedStream;

import java.util.List;

public class EmployeeData {

    public static List<Employee> getEmployees() {
        return List.of(
                new Employee(1, "Amit", "IT", "Chennai", 28, "Male", 45000),
                new Employee(2, "Ravi", "IT", "Bangalore", 35, "Male", 75000),
                new Employee(3, "Sneha", "HR", "Chennai", 32, "Female", 55000),
                new Employee(4, "John", "Finance", "Mumbai", 45, "Male", 85000),
                new Employee(5, "Priya", "HR", "Bangalore", 29, "Female", 48000),
                new Employee(6, "Arun", "IT", "Chennai", 41, "Male", 92000),
                new Employee(7, "Kavya", "Finance", "Mumbai", 38, "Female", 67000),
                new Employee(8, "Vikram", "IT", "Hyderabad", 26, "Male", 40000),
                new Employee(9, "Neha", "HR", "Delhi", 50, "Female", 78000),
                new Employee(10, "Rahul", "Finance", "Bangalore", 55, "Male", 99000),
                new Employee(11, "Suresh", "IT", "Delhi", 33, "Male", 60000),
                new Employee(12, "Anita", "HR", "Mumbai", 42, "Female", 82000)
        );
    }
}