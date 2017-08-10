package com.rohit.java8;

import java.util.concurrent.Callable;

/**
 * Created by Rohit on 10-08-2017.
 * This code is only used for learning purpose.
 */
public class MyCallable implements Callable<String> {
    long waitTime;

    public MyCallable(long waitTime){
        this.waitTime = waitTime;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        return Thread.currentThread().getName();
    }
}
