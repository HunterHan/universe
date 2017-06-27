package com.laiwu.source.code.java.util;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ArraysUsage {

  @Test
  public void copyOf() {
    String[] names = { "tom", "jack", "peter" };
    String[] dst = Arrays.copyOf(names, names.length);
    ArraysUsage.printArray(dst);
  }

  @Test
  public void toStringUsage() {
    String[] names = { "tom", "jack", "peter" };
    String toStringNames = Arrays.toString(names);
    System.out.println(toStringNames);
  }

  /**
   * 打印数组元素
   * @param array
   */
  public static void printArray(String[] array) {
    for (String a : array) {
      System.out.println(a);
    }
  }

  @Test
  public void asListAndSort() {
    String[] names = { "tom", "jack", "peter" };
    List<String> listNames = Arrays.asList(names);
    System.out.println(listNames);

    Arrays.sort(names);
    System.out.println(Arrays.asList(names));
  }

}
