package com.laiwu.source.code.java.virtual.machine.t3;

public class DeadLock {
  // 线程死锁等待演示
  public static class SyncAddRunable implements Runnable {

    int a, b;

    public SyncAddRunable(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public void run() {
      synchronized (Integer.valueOf(a)) {
        synchronized (Integer.valueOf(b)) {
          System.out.println(a + b);
        }
      }
    }
  }

}
