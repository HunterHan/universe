package com.laiwu.source.code.java.util.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
  static final int MAXIMUM_CAPACITY = 1 << 30;


  public static void main(String[] args) {
    Map one = new HashMap<String, String>(12);
    one.put("one", "one");
    System.out.println(one.size());

    int i = tableSizeFor(7);
    System.out.println(i);
  }

  static final int tableSizeFor(int cap) {
    int n = cap - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
  }

}
