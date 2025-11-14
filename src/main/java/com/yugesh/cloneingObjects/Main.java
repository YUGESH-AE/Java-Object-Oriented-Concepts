package com.yugesh.cloneingObjects;

public class Main {

    static void main() {
        Human yugesh=new Human("yugesh",26);
        /*
        Insted of passing the object we can use the clonable interface
         */
       Human twin2=new Human(yugesh);
        Human twin=yugesh.clone();
        System.out.println(twin);
    }
}
