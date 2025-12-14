package com.yugesh.dsa.problems.streams.level_2;

import com.yugesh.dsa.problems.streams.Employee;

import java.util.List;

public class EmployeeNamesOnly {
    static void main() {

        List<Employee> employees = Employee.getEmployeeList();

        List<String>names=employees.stream()
                .map(Employee::getName)
                .toList();
        System.out.println(names);

        long totalSalary= employees.stream()
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println(totalSalary);
    }
}
