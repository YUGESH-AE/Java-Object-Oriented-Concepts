package com.yugesh.featuresOfJava_8.lambda.lambdaWithAndWithoutFunctions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    private final int id;
    private final String name;
    private final int age;
    private final double salary;
}
