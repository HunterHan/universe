package com.laiwu.source.code.java.virtual.machine.t1;

/**
 * 栈溢出，栈内存不足
 * @author CogniBoy
 *
 */
public class StackOOM {
  private void dontStop() {
    while (true) {

    }
  }

  public void stackLeakByThread() {
    while (true) {
      Thread thread = new Thread(new Runnable() {

        @Override
        public void run() {
          dontStop();
        }
      });
      thread.start();
    }
  }

  public static void main(String[] args) {
    StackOOM vm = new StackOOM();
    vm.stackLeakByThread();
  }
}
