package com.yugesh.featuresOfJava_8.staticAndDefault;

@FunctionalInterface
public interface Animal {

    void shout();

    public static void display(){
        System.out.println("This is from the Animal interface");
    }

    public default void defaultMethod1(){
        System.out.println("This is the default method in Animal Interface");
    }
}
