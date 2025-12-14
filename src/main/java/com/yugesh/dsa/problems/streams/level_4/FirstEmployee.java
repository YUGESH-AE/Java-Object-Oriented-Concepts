package com.yugesh.dsa.problems.streams.level_4;

import com.yugesh.dsa.problems.streams.Employee;

import java.util.List;

public class FirstEmployee {

    static void main() {

        List<Employee> employees = Employee.getEmployeeList();

        Employee employee = employees
                .stream()
                .filter(e -> e.getAge() > 40)
                .findFirst().orElse(new Employee());
        System.out.println(employee);

        boolean isFromHr = employees
                .stream()
                .anyMatch(e -> e.getDepartment().equalsIgnoreCase("HR"));
        System.out.println(isFromHr);
    }
}
