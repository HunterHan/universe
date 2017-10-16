package hjava.lang;

import com.laiwu.source.code.java.lang.MyThread;

public class ThreadTest {

  public static void main(String[] args) {

    // MyThread.createBusyThread();

//    Object lock = new Object();
//    MyThread.createWaitingThread(lock);
//
//    try {
//      System.out.println("父线程休眠3秒钟。。。");
//      Thread.sleep(3 * 1000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    synchronized (lock) {
//      System.out.println("父线程notify...");
//      lock.notifyAll();
//    }

    MyThread.createDeadLock();
  }
}
