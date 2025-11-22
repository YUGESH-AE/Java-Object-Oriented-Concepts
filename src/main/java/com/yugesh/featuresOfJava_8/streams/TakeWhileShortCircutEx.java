package com.yugesh.featuresOfJava_8.streams;

import java.util.stream.Stream;

public class TakeWhileShortCircutEx {

    static void main(){

        Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,15)
        .takeWhile(b->{
            System.out.println("Inside the filter:"+b);
            return b<10;
        })
        .forEach(System.out::println);
    }
}
