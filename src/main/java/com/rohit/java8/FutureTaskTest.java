package com.rohit.java8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by Rohit on 10-08-2017.
 * This code is only used for learning purpose.
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable1 = new MyCallable(2000);
        MyCallable myCallable2 = new MyCallable(2000);
        FutureTask<String> futureTask1 = new FutureTask<String>(myCallable1);
        FutureTask<String> futureTask2 = new FutureTask<String>(myCallable2);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(futureTask1);
        executor.execute(futureTask2);

        while (true){
            if(futureTask1.isDone() && futureTask2.isDone()){
                executor.shutdown();
                System.out.println("FutureTask1 output="+futureTask1.get());
                System.out.println("FutureTask2 output="+futureTask2.get());
                break;
            }
            Thread.sleep(100);
            System.out.println("Main Thread is waiting");

        }
    }
}
