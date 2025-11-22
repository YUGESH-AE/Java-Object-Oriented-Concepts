package com.yugesh.featuresOfJava_8.streams;

import java.util.stream.Stream;

public class StreamGenerate {
    
    static void main(){
        
        //it will simply generate a stream of values
        Stream<String>stream=Stream.generate(()->"Hello world");

        stream.forEach(System.out::println);
    }
}
