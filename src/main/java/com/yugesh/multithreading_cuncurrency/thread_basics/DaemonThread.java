package com.yugesh.multithreading_cuncurrency.thread_basics;

public class DaemonThread extends Thread{

    public DaemonThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(true){
        System.out.println("inside "+Thread.currentThread().getName());
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
    }
}
    
}

