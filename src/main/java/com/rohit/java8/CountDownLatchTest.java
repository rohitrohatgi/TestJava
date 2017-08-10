package com.rohit.java8;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Rohit on 10-08-2017.
 * This code is only used for learning purpose.
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(5);
        final CountDownLatch latch1 = new CountDownLatch(5);
        final CountDownLatch latch2 = new CountDownLatch(5);

        for(int x = 0; x < 5; x++)
            service.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                    latch2.countDown();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch1.countDown();
            });


        latch2.await();
        System.out.println("Latch2 Done");

        latch1.await();
        System.out.println("Latch1 Done");
        service.shutdown();
    }
}
