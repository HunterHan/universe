package com.laiwu.source.code.java.virtual.machine.t1;

/**
 * 栈泄露，危险
 * @author CogniBoy
 *
 */
public class StackOverflow {
  public int stacklength = 1;

  public void stackLeak() {
    stacklength++;
    stackLeak();
  }

  public static void main(String[] args) throws Throwable {
    StackOverflow vm = new StackOverflow();
    try {
      vm.stackLeak();
    } catch (Throwable e) {
      System.out.println("stack length:" + vm.stacklength);
      throw e;
    }
  }
}
