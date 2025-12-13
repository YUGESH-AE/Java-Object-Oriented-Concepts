package com.yugesh.featuresOfJava_8.staticAndDefault;

@FunctionalInterface
public interface Human {

    public static void display() {
        System.out.println("This is from the human static method");
    }

    void work();

    public default void defaultMethod1() {
        System.out.println("This is from the default method of human interface");
    }
}
