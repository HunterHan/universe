package com.laiwu.source.code.java.lang;

import org.junit.Test;

/**
 * 创建线程的3种方式:
 * 
 * 1、继承Thread类
 * 
 * 2、实现Runnable接口
 * 
 * 3、实现Callable接口
 * 
 * 2/3 的优势:线程类只是实现了Runnable接口或Callable接口，还可以继承其他类。
 * 多个线程可以共享同一个target对象，所以非常适合多个相同线程来处理同一份资源的情况，
 * 从而可以将CPU、代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。
 * 
 * 注意:多线程下载是指带宽满足前提下同时获取资源
 * 
 * @author CogniBoy
 *
 */
/*线程的状态

Thread.State.NEW
Thread.State.RUNNABLE
Thread.State.BLOCKED
Thread.State.WAITING
Thread.State.TIMED_WAITING
Thread.State.BLOCKED*/
public class MyThread implements Runnable {

  Integer a;
  Integer b;

  public MyThread(Integer a, Integer b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public void run() {
    synchronized (a) {
      synchronized (b) {
        System.out.println(a + b);
      }
    }
  }

  /**
   * 线程死锁
   */
  public static void createDeadLock() {
    for (int i = 0; i < 100; i++) {
      new Thread(new MyThread(1, 2)).start();
      new Thread(new MyThread(2, 1)).start();
    }
  }

  /**
   *  线程等待
   *  
   */
  public static void createWaitingThread(Object lock) {

    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {
        // java.lang.IllegalMonitorStateException 违法的监控状态异常
        // 当某个线程试图等待一个自己并不拥有的对象（O）的监控器或者通知其他线程等待该对象（O）的监控器时，抛出该异常。
        synchronized (lock) {
          try {
            System.out.println("子线程waiting...");
            lock.wait();
            Thread.sleep(3 * 1000);
            System.out.println("子线程wake up...");
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    }, "createWaitingThread");
    thread.start();
  }

  /**
   * 线程死循环
   * 
   * 无法使用junit测试启动线程
   * 
   * Junit的底层实现上，是用System.exit退出用例执行的。JVM都终止了，在测试线程启动的其他线程自然也无法执行。
   */
  public static void createBusyThread() {
    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {
        while (true)
          ;
      }
    }, "createBusyThread");
    thread.start();
  }

  @Test
  public void getCurrentThread() {
    String threadName = Thread.currentThread().getName();
    System.out.println("线程名称:" + threadName);
  }

  @Test
  public void threadRun() {
    new Thread(new Runnable() {

      @Override
      public void run() {
        System.out.println("runnable run");
      }
    }) {
      @Override
      public void run() {
        System.out.println("thread run");
      }
    }.start();

  }

}
