package com.laiwu.source.code.reflect;

import java.lang.reflect.Array;

public class ArrayReflect {
  public static void main(String[] args) throws Exception {
    // 获取String的class对象
    Class<?> type = Class.forName("java.lang.String");
    // 构造一个String类型的数组
    Object array = Array.newInstance(type, 10);
    // 向数组中的索引位置添加元素
    Array.set(array, 1, "hanhongtao");
    // 取出该索引位置的元素并打印
    String string = (String) Array.get(array, 1);
    System.out.println(string);
  }
}
