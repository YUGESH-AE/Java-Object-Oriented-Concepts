package com.yugesh.dsa.problems.streams.level_3;

import com.yugesh.dsa.problems.streams.Employee;

import java.util.List;

public class EmployeeSalary {
    static void main() {
        List<Employee> employees = Employee.getEmployeeList();

        List<String>names=employees
                .stream()
                .filter(s->s.getSalary()>50000)
                .map(Employee::getName)
                .toList();
        System.out.println(names);

        List<Integer>length=employees
                .stream().map(Employee::getName)
                .filter(name -> name.startsWith("A"))
                .map(String::length)
                .toList();
        System.out.println(length);

        long summedSalary=employees.stream()
                .filter(e->e.getDepartment().equalsIgnoreCase("IT"))
                .mapToLong(Employee::getSalary)
                .sum();
        System.out.println(summedSalary);


    }
}
