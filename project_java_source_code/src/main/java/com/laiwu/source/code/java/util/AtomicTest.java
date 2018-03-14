package com.laiwu.source.code.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

  // 使用 AtomicInteger 实现对数据的原子操作
  // 自旋CAS实现：循环进行CAS指导成功为止
  // 通过汇编命令cmpxchg进行的包装与定制
  public static void testAtomicInteger() {

    AtomicInteger number = new AtomicInteger(0);
    number.addAndGet(0);
    System.out.println(number);
    List<Thread> threads = new ArrayList<>(10);

    for (int i = 0; i < 10; i++) {

      Thread t = new Thread(new Runnable() {
        @Override
        public void run() {

          number.addAndGet(1);

        }
      });

      threads.add(t);

    }

    for (Thread thread : threads) {
      thread.start();
    }

    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.print(number);

  }

  public static void main(String[] args) {

    AtomicTest.testAtomicInteger();

  }
}
