package com.yugesh.featuresOfJava_8.lambda.lambdaWithAndWithoutFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EmployeeMain {

    static void main() {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(21, "yugesh", 26, 90000));
        list.add(new Employee(22, "ravi", 36, 8000));
        list.add(new Employee(23, "sanjay", 16, 677));
        list.add(new Employee(24, "shyam", 36, 90000));
        list.add(new Employee(25, "ajai", 46, 123));
        list.add(new Employee(26, "sundar", 12, 6767));
        list.add(new Employee(28, "kumar", 13, 5656));
        list.add(new Employee(90, "raj", 46, 908080));
        list.add(new Employee(100, "sai", 56, 676));
        list.add(new Employee(101, "ram", 16, 5000));
        list.add(new Employee(18, "ravi", 21, 800));

        Predicate<Employee> ageCalculator = e -> e.getAge() > 18;
        //predicate example
        List<Employee> adultEmployee =
                list.stream()
                        .filter(ageCalculator)
                        .toList();
        System.out.println(adultEmployee);

        Function<Employee, String> empName = e -> e.getName();
        List<String> empNames = list.stream()
                .map(empName).toList();
        System.out.println(empNames);

        Consumer<Employee> consumer = e -> System.out.print(e.getName() + ",");

        list.forEach(consumer);

        Supplier<Employee> defaultEmp = () -> new Employee(0, "no_name", 0, 0);
        System.out.println();
        System.out.println("Default employee:" + defaultEmp.get());

    }
}
