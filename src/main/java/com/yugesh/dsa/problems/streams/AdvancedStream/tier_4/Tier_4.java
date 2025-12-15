package com.yugesh.dsa.problems.streams.AdvancedStream.tier_4;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.yugesh.dsa.problems.streams.AdvancedStream.Employee;
import com.yugesh.dsa.problems.streams.AdvancedStream.EmployeeData;

public class Tier_4 {

    public static void main(String[] args) {
        
        List<Employee>employees=EmployeeData.getEmployees();

        Map<String, Map<Boolean,List<Employee>>>departmentPartitionBySalary=
                employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::getDepartment,
                                        Collectors.partitioningBy(
                                                e->e.getSalary()>50000
                                        )
                                )
                        );

        System.out.println(departmentPartitionBySalary);

        Map<String,Map<Boolean,Long>>departmentPartitionByHighLowSalary=
                employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::getDepartment,
                                        Collectors.partitioningBy(
                                                e->e.getSalary()>50000,
                                                Collectors.counting()
                                        )
                                )
                        );

        System.out.println(departmentPartitionByHighLowSalary);

        Map<String,Map<Boolean,List<String>>> cityPartitionNames=employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCity,
                                Collectors.partitioningBy(
                                        e->e.getSalary()>50000,
                                        Collectors.mapping(
                                                Employee::getName,
                                                Collectors.toCollection(LinkedList::new)
                                        )
                                )
                        )
                );

        System.out.println(cityPartitionNames);
    }
}
