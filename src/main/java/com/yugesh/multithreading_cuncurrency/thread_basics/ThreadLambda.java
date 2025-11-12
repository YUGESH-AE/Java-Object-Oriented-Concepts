package com.yugesh.multithreading_cuncurrency.thread_basics;

public class ThreadLambda {
    
    static void main() {

       Thread lambda=new Thread(()->{
               System.out.println("Inside "+Thread.currentThread().getName());
               for(int i=0;i<5;i++){
                   System.out.println(Thread.currentThread().getName()+":"+i);
               }
       },"Lambda expression");
       lambda.start();
    }
}
