package com.yugesh.multithreading_cuncurrency.thread_basics;

public class UserThread2_RunnableExample {


    static void main() {
        try {

            Thread thread = new Thread(new UserThread2_Runnable());
            thread.start();
            thread.join();
            System.out.println("ThreadLambda thread is exiting");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static class UserThread2_Runnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread() + ":" + i);
            }
        }
    }

}
