package com.laiwu.source.code.java.virtual.machine.t3;

import java.util.Map;

public class JStack {
	/**
	 * 查看服务器线程信息
	 * @param args
	 */
  public static void main(String[] args) {
    for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
      Thread thread = (Thread) stackTrace.getKey();
      StackTraceElement[] stack = (StackTraceElement[]) stackTrace.getValue();
      if (thread.equals(Thread.currentThread())) {
        continue;
      }
      System.out.println("\n线程:" + thread.getName() + "\n");
      for (StackTraceElement element : stack) {
        System.out.println("\t" + element + "\n");
      }
    }
  }
}
