package com.yugesh.multithreading_cuncurrency.thread_basics;

public class UserThread extends Thread{

    public UserThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Inside "+Thread.currentThread().getName());
       for(int i=0;i<5;i++){
        System.out.println(Thread.currentThread().getName()+":"+i);
       }
    }
    
}
