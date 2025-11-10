package com.yugesh.multithreading_cuncurrency;

public class Main {
    
    static void main() {

        System.out.println("Main thread is starting");
        Thread1 thread1=new Thread1();
        thread1.start();

        System.out.println("Main thread is exiting");
    }
}
