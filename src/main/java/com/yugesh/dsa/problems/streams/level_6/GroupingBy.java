package com.yugesh.dsa.problems.streams.level_6;

import com.yugesh.dsa.problems.streams.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {
    static void main() {

        List<Employee> employees = Employee.getEmployeeList();

        Map<String, List<Employee>> deptMap = employees
                .stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment)
                );
        System.out.println(deptMap);

        Map<String, Long> countMap = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        )
                );
        System.out.println(countMap);

        Map<String, Double> salaryMap = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingDouble(Employee::getSalary)
                        )
                );

        System.out.println(salaryMap);

        Map<String, List<String>> namesMap = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        )
                );

        System.out.println(namesMap);
    }
}
