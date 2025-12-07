package com.yugesh.featuresOfJava_8.streams.fullExamples;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static void main() {

        List<Employee> employeeList = employeeList();

        mapMethod(employeeList);
        filterMethod(employeeList);
        mapDistinctForEach(employeeList);
        filterCount(employeeList);
        limitMethod(employeeList);
        skipMethod(employeeList);
        anyMatch(employeeList);
        allMatch(employeeList);
        nonMatch(employeeList);
        findAny(employeeList);
        findFirst(employeeList);
        sorted(employeeList);
        min(employeeList);
        max(employeeList);
        average(employeeList);
        collectors_toMap(employeeList);
        collectors_groupBy(employeeList);
        collectors_groupBy_countingAverage(employeeList);
        collectors_groupBy_Count(employeeList);
        collectors_summarizing(employeeList);
        collectors_joining(employeeList);
    }

    /**
     * Collectors.joining()
     * collect all department with delimiter
     *
     * @param employeeList
     */
    public static void collectors_joining(List<Employee> employeeList) {

        String department = employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(
                        Collectors.joining(",", "[", "]")
                );
        System.out.println(department);
    }

    /**
     * Collectors.summarizing()
     * summarizing the salary
     *
     * @param employeeList
     */
    public static void collectors_summarizing(List<Employee> employeeList) {

        DoubleSummaryStatistics s = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(s);
    }

    /**
     * Collectors.groupBy()
     * Collectors.counting()
     * collect the count of employees by gender
     *
     * @param employeeList
     */
    public static void collectors_groupBy_Count(List<Employee> employeeList) {
        Map<String, Long> genderCount =
                employeeList.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Employee::getGender,
                                        Collectors.counting()
                                )
                        );
        System.out.println(genderCount);
    }


    public static void collectors_groupBy_countingAverage(List<Employee> employeeList) {

        Map<String, Double> departmentMap = employeeList
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                );

        System.out.println(departmentMap);
    }

    /**
     * Collectors.groupBy()
     * grouping the city and the employee in that city
     *
     * @param employeeList
     */
    public static void collectors_groupBy(List<Employee> employeeList) {

        Map<String, List<String>> cityMap = employeeList
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getCity,
                                TreeMap::new,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        )
                );

        System.out.println(cityMap);
    }


    /**
     * Collectors.toMap()
     * collecting employee and their salary
     *
     * @param employeeList
     */
    public static void collectors_toMap(List<Employee> employeeList) {
        Map<String, Double> empMap = employeeList.stream()
                .collect(
                        Collectors.toMap(
                                Employee::getName,
                                Employee::getSalary
                        )
                );
        System.out.println(empMap);
    }

    /**
     * average()
     * average salary of the employee
     */
    public static void average(List<Employee> employeeList) {

        double avgSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average().orElse(0.0);
        System.out.println(avgSalary);
    }

    /**
     * max()
     * maximym salary of the employee
     */
    public static void max(List<Employee> employeeList) {
        Employee employee = employeeList.stream()
                .max((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))
                .orElse(new Employee());
        System.out.println(employee);
    }

    /**
     * min()
     * minimum salary of the employee
     *
     * @param employeeList
     */
    public static void min(List<Employee> employeeList) {

        Employee employee = employeeList
                .stream()
                .min((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))
                .orElse(new Employee());

        System.out.println(employee);
        ;

    }

    /**
     * sorted()
     * get employee names in sorted order
     *
     * @param employeeList
     */
    public static void sorted(List<Employee> employeeList) {

        employeeList.stream()
                .map(Employee::getName)
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

    /**
     * findFirst()
     * will get the first occurrence of the list if any
     *
     * @param employeeList
     */
    public static void findFirst(List<Employee> employeeList) {

        Optional<Employee> optionalEmployee = employeeList
                .stream()
                .filter(e -> e.getName().startsWith("S"))
                .findFirst();

        optionalEmployee.ifPresent(System.out::println);
    }

    /**
     * findAny()
     * get one value out of all values
     * any employee who is from banglore
     *
     * @param employeeList
     */
    public static void findAny(List<Employee> employeeList) {

        Optional<Employee> employee = employeeList.stream()
                .filter(e -> e.getCity().equalsIgnoreCase("Bangalore"))
                .findAny();

        employee.ifPresentOrElse(
                System.out::println,
                () -> System.out.println(new Employee().toString())
        );
    }

    /**
     * noneMatch()
     * Every employee salary less than 10 k
     * any one matches false
     * no one matches true
     *
     * @param employeeList
     */
    public static void nonMatch(List<Employee> employeeList) {

        boolean result = employeeList.stream()
                .noneMatch(e -> e.getSalary() < 1000);
        System.out.println(result);
    }


    //

    /**
     * allMatch()
     * every employee who joined after 2010 inclusive allMatch()
     *
     * @param employeeList
     */
    public static void allMatch(List<Employee> employeeList) {
        boolean result = employeeList.stream()
                .allMatch(e -> e.getYearOfJoining() > 2010);
        System.out.println(result);
    }


    /**
     * anyMatch()
     * verify any employee whose age is less than 28 anyMatch()
     *
     * @param employeeList
     */
    public static void anyMatch(List<Employee> employeeList) {

        boolean age = employeeList.stream()
                .anyMatch(a -> a.getAge() < 28);
        System.out.println(age);
    }


    /**
     * skip()
     * skip the first 3 employee
     *
     * @param employeeList
     */
    public static void skipMethod(List<Employee> employeeList) {

        employeeList.stream()
                .skip(3)
                .forEach(System.out::println);
    }


    /**
     * limit()
     * get the first 3 employees
     *
     * @param employeeList
     */
    public static void limitMethod(List<Employee> employeeList) {
        List<Employee> employees = employeeList
                .stream()
                .limit(3)
                .toList();
        System.out.println(employees);
    }


    /**
     * count()
     * count of employees whos salary is greater than 70k
     *
     * @param employeeList
     */
    public static void filterCount(List<Employee> employeeList) {

        long count = employeeList.stream()
                .filter(e -> e.getSalary() > 70000)
                .count();
        System.out.println(count);
    }


    /**
     * map(), distinct(), forRach()
     * printing all the city names of the employees
     *
     * @param employeeList
     */
    public static void mapDistinctForEach(List<Employee> employeeList) {

        employeeList.stream()
                .map(Employee::getCity)
                .distinct()
                .forEach(System.out::println);
    }


    /**
     * filter(), map(), toList()
     * filtering employees whose age is > 25
     *
     * @param employeeList
     */
    public static void filterMethod(List<Employee> employeeList) {

        List<String> employees = employeeList.stream()
                .filter(e -> e.getAge() > 25)
                .map(Employee::getName)
                .toList();
        System.out.println(employees);
    }


    /**
     * map(), toList()
     * getting all the employee names
     *
     * @param employeeList
     */
    public static void mapMethod(List<Employee> employeeList) {
        List<String> employeeNames = employeeList.stream()
                .map(Employee::getName)
                .toList();

        System.out.println(employeeNames);
    }


    public static List<Employee> employeeList() {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, "Arjun", "Chennai", 28, "Male", "IT", 2019, 65000));
        employeeList.add(new Employee(2, "Priya", "Chennai", 26, "Female", "HR", 2020, 52000));
        employeeList.add(new Employee(3, "Karthik", "Bangalore", 32, "Male", "Finance", 2018, 78000));
        employeeList.add(new Employee(4, "Meera", "Hyderabad", 29, "Female", "IT", 2021, 60000));
        employeeList.add(new Employee(5, "Vikram", "Chennai", 35, "Male", "Admin", 2015, 50000));
        employeeList.add(new Employee(6, "Divya", "Pune", 30, "Female", "IT", 2017, 70000));
        employeeList.add(new Employee(7, "Sanjay", "Delhi", 45, "Male", "Management", 2010, 120000));
        employeeList.add(new Employee(8, "Anjali", "Chennai", 27, "Female", "IT", 2022, 48000));
        employeeList.add(new Employee(9, "Ravi", "Bangalore", 31, "Male", "Sales", 2019, 55000));
        employeeList.add(new Employee(10, "Nisha", "Mumbai", 33, "Female", "Finance", 2016, 82000));

        employeeList.add(new Employee(11, "Hari", "Chennai", 29, "Male", "Support", 2020, 40000));
        employeeList.add(new Employee(12, "Sneha", "Hyderabad", 28, "Female", "Marketing", 2019, 58000));
        employeeList.add(new Employee(13, "Manoj", "Chennai", 34, "Male", "IT", 2014, 90000));
        employeeList.add(new Employee(14, "Lavanya", "Bangalore", 25, "Female", "HR", 2021, 45000));
        employeeList.add(new Employee(15, "Gopal", "Pune", 38, "Male", "Management", 2012, 110000));
        employeeList.add(new Employee(16, "Harini", "Chennai", 30, "Female", "IT", 2018, 75000));
        employeeList.add(new Employee(17, "Vignesh", "Hyderabad", 28, "Male", "Admin", 2020, 47000));
        employeeList.add(new Employee(18, "Aishwarya", "Delhi", 31, "Female", "Support", 2017, 52000));
        employeeList.add(new Employee(19, "Suresh", "Bangalore", 36, "Male", "IT", 2015, 105000));
        employeeList.add(new Employee(20, "Kavya", "Chennai", 24, "Female", "Sales", 2022, 38000));

        employeeList.add(new Employee(21, "Rahul", "Pune", 29, "Male", "IT", 2019, 65000));
        employeeList.add(new Employee(22, "Pooja", "Mumbai", 33, "Female", "Finance", 2017, 78000));
        employeeList.add(new Employee(23, "Varun", "Hyderabad", 26, "Male", "Marketing", 2021, 54000));
        employeeList.add(new Employee(24, "Janani", "Chennai", 28, "Female", "IT", 2020, 60000));
        employeeList.add(new Employee(25, "Mohan", "Delhi", 41, "Male", "Management", 2013, 125000));
        employeeList.add(new Employee(26, "Sahana", "Bangalore", 27, "Female", "Sales", 2022, 52000));
        employeeList.add(new Employee(27, "Ajay", "Hyderabad", 32, "Male", "Admin", 2018, 45000));
        employeeList.add(new Employee(28, "Ramya", "Pune", 30, "Female", "Support", 2019, 43000));
        employeeList.add(new Employee(29, "Naveen", "Chennai", 35, "Male", "IT", 2016, 98000));
        employeeList.add(new Employee(30, "Shalini", "Mumbai", 28, "Female", "Finance", 2020, 70000));
        return employeeList;
    }


}
