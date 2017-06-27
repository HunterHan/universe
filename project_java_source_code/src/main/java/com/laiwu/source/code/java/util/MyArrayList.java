package com.laiwu.source.code.java.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class MyArrayList {

  /**
   * 遍历执行clear()的List，数组中每个索引位置置为null，等待JVM自动垃圾回收
   */
  @Test
  public void clear() {

    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    list.clear();

    System.out.println("size:" + list.size());
    System.out.println("isEmpty:" + list.isEmpty());
  }

  /**
   * 返回指定元素的索引位置
   * 若不存在该元素，返回 -1
   */
  @Test
  public void indexOf() {
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    int index = list.indexOf(3);
    System.out.println(index);

    index = list.indexOf(4);
    System.out.println(index);
  }

  @Test
  public void remove() {
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    System.out.println(list);

    list.remove(0);

    System.out.println(list);
  }

  /**
   * 简单的iterator迭代器完成遍历
   */
  @Test
  public void iterator1() {
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      Integer integer = iterator.next();
      System.out.println(integer);
    }
  }

  /**
   * iterator迭代器控制边界的for循环遍历
   */
  @Test
  public void iterator2() {
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
      Integer integer = (Integer) iterator.next();
      System.out.println(integer);
    }
  }

  /**
   * 简单size大小for循环遍历
   */
  @Test
  public void iterator3() {
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  /**
   * 增强for循环表达式
   */
  @Test
  public void iterator4() {
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);

    for (Integer i : list) {
      System.out.println(i);
    }
  }
}
