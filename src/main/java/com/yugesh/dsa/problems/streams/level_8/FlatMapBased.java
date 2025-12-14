package com.yugesh.dsa.problems.streams.level_8;

import com.yugesh.dsa.problems.streams.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMapBased {

    static void main() {

        List<List<Integer>> numbers = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5)
        );

        List<Integer> num = numbers.stream()
                .flatMap(Collection::stream)
                .map(i -> i)
                .toList();

        System.out.println(num);

        List<Employee> employees = Employee.getEmployeeList();
        Map<String, List<Employee>> departmentMap = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment
                        )
                );

        System.out.println(departmentMap);

        List<String> names = departmentMap
                .values()
                .stream()
                .flatMap(List::stream)
                .map(Employee::getName)
                .toList();
        System.out.println(names);

    }
}
