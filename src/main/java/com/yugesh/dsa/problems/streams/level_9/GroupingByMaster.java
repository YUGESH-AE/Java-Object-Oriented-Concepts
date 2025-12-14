package com.yugesh.dsa.problems.streams.level_9;

import com.yugesh.dsa.problems.streams.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByMaster {

    static void main() {

        List<Employee> employees = Employee.getEmployeeList();

        Map<String, List<String>> employeeDepart = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        )
                );

        System.out.println(employeeDepart);


        Map<String, Integer> employeeSalaryDep = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.reducing(
                                        0,
                                        Employee::getSalary,
                                        Integer::max
                                )
                        )
                );
        System.out.println(employeeSalaryDep);

        Map<String, Integer> employeeCountDepartment = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.counting(),
                                        Long::intValue
                                )
                        )
                );
        System.out.println(employeeCountDepartment);

        Map<String, Map<String, List<Employee>>> map =
                employees
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::getDepartment,
                                        Collectors.groupingBy(
                                                e -> {
                                                    if (e.getAge() < 30) return "YOUNG";
                                                    else if (e.getAge() <= 50) {
                                                        return "MID";
                                                    } else {
                                                        return "SENIOR";
                                                    }
                                                }
                                        )
                                )
                        );
        System.out.println(map);

        Map<String, Double> avgSalary = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                );
        System.out.println(avgSalary);
    }
}
