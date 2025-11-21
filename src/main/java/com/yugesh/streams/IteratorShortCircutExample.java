package com.yugesh.streams;

import java.util.stream.Stream;

//limit skip are short circuit opeartor
public class IteratorShortCircutExample {
    

    static void main(){

        Stream.iterate(0, n->n+1)
        .skip(20)
        .limit(20)
        .forEach(System.out::println);
    }
}
