package com.yugesh.multithreading_cuncurrency;

public class UserThread2_Runnable implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<3;i++){
            System.out.println(Thread.currentThread()+":"+i);
        }
    }
}
