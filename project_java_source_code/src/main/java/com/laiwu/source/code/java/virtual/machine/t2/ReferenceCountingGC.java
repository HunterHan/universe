package com.laiwu.source.code.java.virtual.machine.t2;

public class ReferenceCountingGC {

  public Object instance = null;

  // 这个成员属性的意义是占内存，以便能在GC日志中看清楚是否被回收过
  private static final int _1MB = 1024 * 1024;

  private byte[] bigSize = new byte[2 * _1MB];

  public static void gc() {
    ReferenceCountingGC objA = new ReferenceCountingGC();
    ReferenceCountingGC objB = new ReferenceCountingGC();

    objA.instance = objB;
    objB.instance = objA;

    objA = null;
    objB = null;

    System.gc();
  }
}
