package com.yugesh.featuresOfJava_8;

public class Interface_Java_8 implements MyInterface {
    
    @Override
    public void defaultMethod() {
        System.out.println("Overriding the default method in the implementing class.");
    }

    static void main() {
        Interface_Java_8 obj = new Interface_Java_8();
        obj.defaultMethod(); // Calls the overridden default method

        MyInterface.staticMethod(); // Calls the static method from the interface
    }

}

interface MyInterface {

    // Default method
    default void defaultMethod() {
        System.out.println("This is a default method in the interface.");
    }

    // Static method
    static void staticMethod() {
        System.out.println("This is a static method in the interface.");
    }
}