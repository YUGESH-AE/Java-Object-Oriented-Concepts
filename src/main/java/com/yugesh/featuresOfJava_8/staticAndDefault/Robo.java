package com.yugesh.featuresOfJava_8.staticAndDefault;

public class Robo implements Animal, Human {

    static void main() {
        Robo r = new Robo();
        r.shout();
        r.work();
        r.defaultMethod1();
    }

    @Override
    public void work() {

        System.out.println("Working in a class");
    }

    @Override
    public void shout() {
        System.out.println("shouting in a class");
    }

    /**
     * if we override the default method where two interface having the same default method
     * we will have a problem, to get rid of that we should use interfacename.super.default method name
     * to avoid the ambiguity
     */
    @Override
    public void defaultMethod1() {
        Animal.super.defaultMethod1();
        Human.super.defaultMethod1();
    }

}
