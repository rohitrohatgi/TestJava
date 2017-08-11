package com.rohit.java8;

/**
 * Created by Rohit on 11-08-2017.
 * This code is only used for learning purpose.
 */
public class ThreadInterferenceTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(()->{for(int i=0;i<10000;i++)counter.increment();});
        Thread thread2 = new Thread(()->{for(int i=0;i<10000;i++)counter.decrement();});
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(counter.value());
    }
}
