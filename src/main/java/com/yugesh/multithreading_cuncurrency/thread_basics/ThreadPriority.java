package com.yugesh.multithreading_cuncurrency.thread_basics;

public class ThreadPriority {

    static void main() {

        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getPriority());
    }
}
