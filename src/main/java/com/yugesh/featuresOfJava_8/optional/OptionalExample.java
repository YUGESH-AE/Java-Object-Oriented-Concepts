package com.yugesh.featuresOfJava_8.optional;

import java.util.Optional;

public class OptionalExample {

    static void main() {

//        ifPresentOrElse();
        orElse();
        orElseGet();
    }

    public static String getName() {
        return "yugesh";
    }

    public static void ifPresentOrElse() {
        Optional<String> maybe = Optional.ofNullable(getName());

        maybe
                .filter(s -> s.length() > 2)
                .map(String::toUpperCase)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No valid names"));
    }

    public static void orElse() {

        Optional<String> maybe = Optional.ofNullable(getName());

        String result = maybe.filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .orElse("Default");

        System.out.println(result);
    }

    public static String feedBack() {
        return "The default value";
    }

    public static void orElseGet() {

        Optional<String> maybe = Optional.ofNullable(getName());

        String result = maybe.filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .orElseGet(() -> feedBack());

        System.out.println(result);
    }


}
