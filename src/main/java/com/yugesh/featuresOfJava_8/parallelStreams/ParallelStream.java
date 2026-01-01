package com.yugesh.featuresOfJava_8.parallelStreams;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter

public class ParallelStream {


    static void main() {

        System.out.println(Runtime.getRuntime().availableProcessors());
        long startTime = System.currentTimeMillis();
        Map<Integer, List<String>> m = getStudents()
                .stream()
                .parallel()
                .collect(
                        Collectors.groupingBy(
                                Student::getAge,
                                Collectors.mapping(
                                        Student::getName,
                                        Collectors.toList()
                                )
                        )
                );
        long endTime = System.currentTimeMillis();

        m.entrySet()
                .stream()
                .parallel()
                .forEachOrdered(System.out::println);
        System.out.println(endTime - startTime);
    }


    public static List<Student> getStudents() {
        return Arrays.asList(
                new Student(1, "Arun", 9000000001L, 18),
                new Student(2, "Bala", 9000000002L, 19),
                new Student(3, "Charan", 9000000003L, 20),
                new Student(4, "Deepa", 9000000004L, 21),
                new Student(5, "Esha", 9000000005L, 22),
                new Student(6, "Farhan", 9000000006L, 20),
                new Student(7, "Gokul", 9000000007L, 23),
                new Student(8, "Hari", 9000000008L, 19),
                new Student(9, "Isha", 9000000009L, 18),
                new Student(10, "Jaya", 9000000010L, 21),

                new Student(11, "Karthik", 9000000011L, 22),
                new Student(12, "Lavanya", 9000000012L, 20),
                new Student(13, "Manoj", 9000000013L, 23),
                new Student(14, "Nisha", 9000000014L, 19),
                new Student(15, "Omkar", 9000000015L, 24),
                new Student(16, "Priya", 9000000016L, 21),
                new Student(17, "Rahul", 9000000017L, 22),
                new Student(18, "Sneha", 9000000018L, 20),
                new Student(19, "Tarun", 9000000019L, 23),
                new Student(20, "Usha", 9000000020L, 18),

                new Student(21, "Varun", 9000000021L, 24),
                new Student(22, "Wafa", 9000000022L, 19),
                new Student(23, "Xavier", 9000000023L, 21),
                new Student(24, "Yamini", 9000000024L, 22),
                new Student(25, "Zara", 9000000025L, 20),
                new Student(26, "Ajay", 9000000026L, 23),
                new Student(27, "Bhavya", 9000000027L, 21),
                new Student(28, "Chitra", 9000000028L, 19),
                new Student(29, "Dev", 9000000029L, 22),
                new Student(30, "Kiran", 9000000030L, 24)
        );
    }
}
