package com.yugesh.dsa.problems.streams.AdvancedStream.tier_3;

import com.yugesh.dsa.problems.streams.AdvancedStream.Employee;
import com.yugesh.dsa.problems.streams.AdvancedStream.EmployeeData;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tier_3 {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeData.getEmployees();

        Map<Boolean, List<Employee>> partitionByAge =
                employees.stream()
                        .collect(
                                Collectors.partitioningBy(
                                        e -> e.getAge() > 40

                                )
                        );

        System.out.println(partitionByAge);


        Map<Boolean, Long> partitionBySalary = employees.stream()
                .collect(
                        Collectors.partitioningBy(
                                e -> e.getSalary() > 60000,
                                Collectors.counting()
                        )
                );

        System.out.println(partitionBySalary);

        Map<Boolean, List<String>> partitionByName = employees.stream()
                .collect(
                        Collectors.partitioningBy(
                                e -> e.getAge() > 40,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toCollection(LinkedList::new)
                                )
                        )
                );

        System.out.println(partitionByName);
    }
}
