package com.dev.countdownlatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class Thread0312 implements Callable {

    CountDownLatch begin;
    CountDownLatch end;
    int NO;

    public Thread0312(CountDownLatch begin, CountDownLatch end, int i) {
        this.begin = begin;
        this.end = end;
        this.NO = i;
    }

    @Override
    public Object call() throws Exception {
        try {
            begin.await();//一直阻塞
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("No." + NO + " arrived");
        } catch (InterruptedException e) {
        } finally {
            end.countDown();
        }

        return NO;
    }
}
