package com.laiwu.source.code.java.virtual.machine.t3;

public class JConsoleJstack {
  /**
   * 线程死循环演示
   */
  public static void createBusyThread() {
    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {
        while (true)
          ;
      }
    }, "testBusyThread");
    thread.start();
  }

  /**
   * 线程锁等待演示
   */
  public static void createLockThread(final Object lock) {
    Thread thread = new Thread(new Runnable() {

      @Override
      public void run() {
        synchronized (lock) {
          try {
            lock.wait();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    }, "testLockThread");
    thread.start();
  }
}
