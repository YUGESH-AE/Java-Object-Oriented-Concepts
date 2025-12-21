package com.yugesh.dsa.problems.streams.AdvancedStream.tier_2;


import com.yugesh.dsa.problems.streams.AdvancedStream.Employee;
import com.yugesh.dsa.problems.streams.AdvancedStream.EmployeeData;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class DownStream {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeData.getEmployees();

        Map<String, Integer> salaryCity = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCity,
                                Collectors.reducing(
                                        0
                                        , Employee::getSalary,
                                        Integer::max
                                )
                        )
                );

        System.out.println(salaryCity);


        Map<String, Optional<Employee>> lowestSalaryByCity = employees
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCity,
                                Collectors.minBy(
                                        Comparator.comparing(Employee::getSalary)
                                )
                        )
                );

        System.out.println(lowestSalaryByCity);


        Map<String, Integer> employeeCountPerCity = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCity,
                                Collectors.collectingAndThen(
                                        Collectors.counting(),
                                        Long::intValue
                                )
                        )
                );

        System.out.println(employeeCountPerCity);

    }

}
