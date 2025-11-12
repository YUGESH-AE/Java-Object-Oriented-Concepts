package com.yugesh.multithreading_cuncurrency.atomicityExample;

public class WithoutAtomicityExample {

    private static volatile int counter=0;


    static void increment(){
        for(int i=0;i<1_00_000;i++){
            counter++;
        }
    }

    public String toString(){
        return "Counter value: "+counter;
    }

    static void main(){
        try{

            Thread t1=new Thread(WithoutAtomicityExample::increment);
            Thread t2=new Thread(WithoutAtomicityExample::increment);

            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println(counter);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}