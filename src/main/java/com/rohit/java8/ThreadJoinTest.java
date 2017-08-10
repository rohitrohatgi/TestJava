package com.rohit.java8;

/**
 * Created by Rohit on 10-08-2017.
 * This code is only used for learning purpose.
 */
public class ThreadJoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        System.out.println("Calling Join");
        t1.join();
        t2.join();
        System.out.println("Done");
    }

}
