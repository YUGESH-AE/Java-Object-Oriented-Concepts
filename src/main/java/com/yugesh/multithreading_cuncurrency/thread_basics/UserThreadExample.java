package com.yugesh.multithreading_cuncurrency.thread_basics;

public class UserThreadExample {

    public static class UserThread extends Thread {
        public UserThread(String name) {
            super(name);
        }

        static void main() {
            try {
                System.out.println("ThreadLambda thread is starting");
                UserThread userThread = new UserThread("user thread");
                userThread.start();
                userThread.join();
                System.out.println("ThreadLambda Thread");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        @Override
        public void run() {
            System.out.println("Inside " + Thread.currentThread().getName());
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }


    }


}
