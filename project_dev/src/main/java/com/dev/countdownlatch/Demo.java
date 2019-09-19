package com.dev.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 开始的倒数锁
        final CountDownLatch begin = new CountDownLatch(1);
        // 结束的倒数锁
        final CountDownLatch end = new CountDownLatch(10);
        // 十名选手
        final ExecutorService exec = Executors.newFixedThreadPool(10);

        List<Future> futures = new ArrayList<>();

        for (int index = 0; index < 10; index++) {

            Future submit = exec.submit(new Thread0312(begin, end, index + 1));
            futures.add(submit);

        }

        System.out.println("Game Start");
        begin.countDown();
        end.await();
        System.out.println("Game Over");
        for(int i = 0;i < futures.size();i++) {

            Object o = futures.get(i).get();
            System.out.println(o);

        }
        exec.shutdown();

    }

}
