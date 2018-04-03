package com.laiwu.algorithm.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

  public static void main(String[] args) {

    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("one", 3);
    map.put("two", 2);
    map.put("three", 1);

    Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

    while (iterator.hasNext()) {
      Map.Entry<String, Integer> next = iterator.next();
      String key = next.getKey();
      Integer value = next.getValue();
      System.out.println(key + " " + value);
    }
  }

}
