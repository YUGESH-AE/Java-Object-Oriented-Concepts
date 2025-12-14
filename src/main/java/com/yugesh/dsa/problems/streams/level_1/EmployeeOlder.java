package com.yugesh.dsa.problems.streams.level_1;

import com.yugesh.dsa.problems.streams.Employee;

import java.util.List;

public class EmployeeOlder {

    static void main() {
        List<Employee> employees = Employee.getEmployeeList();

        List<Employee>older=employees.stream()
                .filter(e->e.getAge()>30)
                .toList();
        System.out.println(older);

    }
}

