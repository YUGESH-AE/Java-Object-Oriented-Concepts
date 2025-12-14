package com.yugesh.dsa.problems.streams.AdvancedStream.tier_1;

import com.yugesh.dsa.problems.streams.AdvancedStream.Employee;
import com.yugesh.dsa.problems.streams.AdvancedStream.EmployeeData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy_1 {
    static void main() {

        List<Employee> employees = EmployeeData.getEmployees();

        Map<String, List<Employee>> groupingCity = employees
                .stream()
                .collect(
                        Collectors.groupingBy(Employee::getCity)
                );

        System.out.println(groupingCity);

        Map<String, Long> countCity = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getCity,
                                Collectors.counting()
                        )
                );

        System.out.println(countCity);

        Map<String, List<String>> nameCity = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCity,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        )
                );

        System.out.println(nameCity);

        Map<String, Double> avgSalaryCity = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCity,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                );
        System.out.println(avgSalaryCity);
    }
}
