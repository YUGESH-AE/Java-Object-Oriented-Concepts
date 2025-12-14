package com.yugesh.dsa.problems.streams;

import lombok.*;

import java.util.List;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

   public String name;
   public int age;
   public int salary;
   public String department;


   public static List<Employee> getEmployeeList(){
        List<Employee> employees = List.of(
                new Employee("Amit", 25,25000,"IT"),
                new Employee("Ravi", 35,40000,"Admin"),
                new Employee("John", 40,60000,"Admin"),
                new Employee("Arun", 50,40000,"Hr")
        );
        return employees;
    }
}

