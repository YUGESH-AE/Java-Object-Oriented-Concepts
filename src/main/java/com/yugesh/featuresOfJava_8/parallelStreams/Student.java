package com.yugesh.featuresOfJava_8.parallelStreams;

import com.github.javafaker.IdNumber;
import com.github.javafaker.Number;
import com.github.javafaker.PhoneNumber;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    private int id;
    private String name;
    private long mobileNo;
    private int age;

}
