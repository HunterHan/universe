package com.laiwu.source.code.thread;

/**
 * 线程的join的含义就是将几个并行线程的线程合并为一个单线程执行
 * 
 * 应用场景 是当一个线程必须等待另一个线程执行完毕才能执行时可以使用 join 方法
 * 
 */
public class Join {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new MyThread1();
    thread.start();

    for (int i = 1; i < 5; i++) {
      if (i >= 2)
        thread.join();
      System.out.println("主线程第" + i + "次执行");
    }
  }
}

class MyThread1 extends Thread {
  @Override
  public void run() {
    for (int i = 1; i < 10; i++) {
      System.out.println("副线程第" + i + "次执行");
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
