package com.yugesh.multithreading_cuncurrency.atomicityExample;

import java.util.concurrent.atomic.AtomicInteger;

public class WithAtomicIntegerExample {
    
    public static AtomicInteger counter=new AtomicInteger(0);

    static void increment(){
        for(int i=0;i<1_00_000;i++){
            counter.incrementAndGet();
        }
    }

    static void main(){
        try{

            Thread t1=new Thread(WithAtomicIntegerExample::increment);
            Thread t2=new Thread(WithAtomicIntegerExample::increment);

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println(counter.get());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
