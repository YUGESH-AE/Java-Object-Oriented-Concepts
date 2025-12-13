package com.yugesh.featuresOfJava_8.staticAndDefault;

@FunctionalInterface
public interface Animal {

    public static void display() {
        System.out.println("This is from the Animal interface");
    }

    void shout();

    public default void defaultMethod1() {
        System.out.println("This is the default method in Animal Interface");
    }
}
