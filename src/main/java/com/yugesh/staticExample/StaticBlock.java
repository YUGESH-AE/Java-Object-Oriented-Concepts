package com.yugesh.staticExample;

public class StaticBlock {

    static int a = 4;

    static int b = 5;

    static {
        System.out.println("Inside the static block");
        b = b * a;
    }

    /***
     Static block will run only once when the first object is created,
     i.e when the class is loaded for the very first time.

     */
    public static void main(String[] args) {
        StaticBlock obj1 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

    }
}
