package com.laiwu.source.code.java.lang;

import org.junit.Test;

public class MyInteger {

  /**
   * [将int类型的元素转为二进制表示]
   */
  @Test
  public void toBinaryString() {
    int number = 16;
    System.out.println(Integer.toBinaryString(number));
    number >>>= 3;
    System.out.println(Integer.toBinaryString(number));
  }

  public static void autoBoxing() {
    Integer integer1 = 100;
    Integer integer2 = 100;
    // true 自动装箱的两个缓存中的 Integer对象的引用比较
    System.out.println("integer1 == integer2: " + (integer1 == integer2));
    System.out.println("integer1.equals(integer2): " + (integer1.equals(integer2)));// true
    System.out.println("integer1.compare(integer2): " + integer1.compareTo(integer2));// 0

    System.out.println();

    Integer integer3 = 200;
    Integer integer4 = 200;
    // false 自动装箱的两个new Integer的引用比较
    System.out.println("integer3 == integer4: " + (integer3 == integer4));
    // false 将两个对象拆箱，再比较大小
    System.out.println("integer3 > integer4: " + (integer3 > integer4));
    System.out.println("integer3.equals(integer4): " + (integer3.equals(integer4)));// true
    System.out.println("integer3.compare(integer4): " + integer3.compareTo(integer4));// 0

    System.out.println();

    Integer integer5 = new Integer(100);
    Integer integer6 = new Integer(100);
    // false 两个不同的Integer对象引用的比较
    System.out.println("integer5 == integer6: " + (integer5 == integer6));
    System.out.println("integer5.equals(integer6): " + (integer5.equals(integer6)));// true
    System.out.println("integer5.compare(integer6): " + integer5.compareTo(integer6));// 0

    System.out.println();

    int int1 = 100;
    // true Integer缓存对象拆箱后与int比较
    System.out.println("integer1 == int1: " + (integer1 == int1));
    System.out.println("integer1.equals(int1): " + (integer1.equals(int1)));// true
    System.out.println("integer1.compare(int1): " + integer1.compareTo(int1));// 0

    System.out.println();

    int int2 = 200;
    // true Integer对象拆箱后与int比较
    System.out.println("integer3 == int2: " + (integer3 == int2));
    System.out.println("integer3.equals(int2): " + (integer3.equals(int2)));// true
    System.out.println("integer3.compare(int2): " + integer3.compareTo(int2));// 0

    System.out.println();

    Integer a = 1;
    Integer b = 2;
    Integer c = 3;
    Integer d = 3;
    Integer e = 321;
    Integer f = 321;
    // Integer g = 3L; 编译报错，不能从Long类型转为Integer，需要强制转换

    System.out.println(c == d);
    System.out.println(e == f);
    System.out.println(c == (a + b));
    System.out.println(c.equals(a + b));
  }
}
