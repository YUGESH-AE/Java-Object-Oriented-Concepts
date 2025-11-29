package com.yugesh.multithreading_cuncurrency.executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureProblems {

    static void main() {

        try(ExecutorService service= Executors.newCachedThreadPool()){

            /**
             * This a bad practice as we are submitting the task and
             *immediately calling the future.get
             *this will make the program work sequentially
             */
//            for(int i=0;i<100;i++){
//                Future<Integer> future=service.submit(new Task());
//                System.out.println(future.get());
//            }
//            System.out.println("Task completed");

            /**
             * The best approach is 1st submit all the task
             * then get the result
             * so which ever task completed we will be getting those result
             */

            List<Future<Integer>>futureList=new ArrayList<>();
            for(int i=0;i<100;i++){
                futureList.add(service.submit(new Task()));
            }

            for(Future<Integer> future:futureList){
                System.out.println(future.get());
            }


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    static class Task implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            return new Random().nextInt();
        }
    }
}
