package com.yugesh.dsa.problems.streams.level_5;

import com.yugesh.dsa.problems.streams.Employee;

import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;

public class Streams {
    static void main() {

        List<Integer>num=List.of(1,2,3,4,5,6,7,8,9,10);

        int sumNum=num.stream()
                .reduce(0, Integer::sum);
        System.out.println(sumNum);

        OptionalInt max=num.stream()
                .mapToInt(i->i)
                .max();
        System.out.println(max.getAsInt());

        List<Employee>employees=Employee.getEmployeeList();

        OptionalDouble salary= employees.stream()
                .mapToDouble(Employee::getSalary)
                .min();
        System.out.println(salary.getAsDouble());

        double product= num.stream()
                .reduce(1,(a,b)->a*b);
        System.out.println(product);

    }
}
