package com.yugesh.streams;

import java.util.stream.Stream;

public class StreamFilters {
    

    static void main(){

        Stream
        .of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
        .peek(i->System.out.println("The Number from the stream:"+i))
        .filter(i->i%2==0)
        .forEach(System.out::println);
    }
}
