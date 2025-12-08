package com.yugesh.featuresOfJava_8.staticAndDefault;

@FunctionalInterface
public interface Human {

    void work();

    public static void display(){
        System.out.println("This is from the human static method");
    }

    public default void defaultMethod1(){
        System.out.println("This is from the default method of human interface");
    }
}
