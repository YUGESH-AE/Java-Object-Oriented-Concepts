package com.yugesh.multithreading_cuncurrency;

public class DaemonThread extends Thread{

    public DaemonThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("inside "+Thread.currentThread().getName());
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
