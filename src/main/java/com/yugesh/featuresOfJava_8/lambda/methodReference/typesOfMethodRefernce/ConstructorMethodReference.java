package com.yugesh.featuresOfJava_8.lambda.methodReference.typesOfMethodRefernce;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ConstructorMethodReference {

    static void main() {
        Supplier<Student> supplier = Student::new;
        Student student = supplier.get();
        System.out.println(student);

        BiFunction<String, Integer, Student> function = Student::new;
        System.out.println(function.apply("RaviKumar", 29));
    }
}

@ToString
@AllArgsConstructor
class Student {

    private String name;
    private int age;

    public Student() {
        name = "yugesh";
        age = 26;

    }

}
