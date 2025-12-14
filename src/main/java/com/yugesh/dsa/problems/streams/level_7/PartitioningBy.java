package com.yugesh.dsa.problems.streams.level_7;

import com.yugesh.dsa.problems.streams.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PartitioningBy {
    static void main() {

        List<Employee>employees=Employee.getEmployeeList();

        Map<Boolean,List<Employee>>salaryPartition=employees
                .stream()
                .collect(
                        Collectors.partitioningBy(e->e.getSalary()>50000)
                );
        System.out.println(salaryPartition);

        Map<Boolean,List<Employee>>departmentPar=employees
                .stream()
                .collect(
                        Collectors.partitioningBy(e->e.getDepartment().equalsIgnoreCase("IT"))
                );
        System.out.println(departmentPar);

        Map<Boolean,List<String>>seniorNames=employees
                .stream()
                .collect(
                      Collectors.partitioningBy(e->e.getAge()>40,Collectors.mapping(Employee::getName,Collectors.toList()))
                );

        System.out.println(seniorNames);

        Map<Boolean,Long>salary=employees
                .stream()
                .collect(
                        Collectors.partitioningBy(e->e.getSalary()>5000,Collectors.counting())
                );
        System.out.println(salary);
    }

}
