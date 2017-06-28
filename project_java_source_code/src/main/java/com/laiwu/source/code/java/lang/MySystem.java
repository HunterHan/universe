package com.laiwu.source.code.java.lang;

import com.laiwu.source.code.java.util.MyArrays;

public class MySystem {

  /**
   * 该方法的精度与底层操作系统有关，很多操作系统使用的时间是以几十毫秒为单位的。
   * 如果需要非常精确的时间，可以使用nanoTime()方法。
   */
  public static void compareTimePrecision() {
    System.out.println("System获取时间精度比对");
    long timeMillis = System.currentTimeMillis();
    long nanoTime = System.nanoTime();
    System.out.println("System.currentTimeMillis():\t" + timeMillis + "\nSystem.nanoTime():\t\t" + nanoTime);
  }

  /**
   *  数组元素的复制
   */
  public static void arrayCopy() {
    String[] names = { "tom", "jack", "peter" };
    String[] dest = new String[names.length];
    System.arraycopy(names, 0, dest, 0, names.length);
    MyArrays.printArray(dest);
  }
}
