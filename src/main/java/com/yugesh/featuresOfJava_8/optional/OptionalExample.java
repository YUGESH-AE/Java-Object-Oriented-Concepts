package com.yugesh.featuresOfJava_8.optional;

import java.util.Optional;

public class OptionalExample {

    static void main(){

       Optional<String> maybe= Optional.ofNullable(getName());

       maybe
       .filter(s->s.length()>2)
       .map(String::toUpperCase)
       .ifPresentOrElse(
        System.out::println, 
        ()->System.out.println("No valid names"));
    }

    public static String getName(){
        return null;
    }
        
    

}
