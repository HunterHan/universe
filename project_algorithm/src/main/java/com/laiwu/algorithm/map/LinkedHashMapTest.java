package com.laiwu.algorithm.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

  public static void main(String[] args) {

    Map<String, String> map = new LinkedHashMap<String, String>(16, 0.75f, true);
    map.put("one", "one");
    map.put("two", "two");
    map.put("three", "three");


    Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

    while (iterator.hasNext()) {
      Map.Entry<String, String> next = iterator.next();
      String key = next.getKey();
      String value = next.getValue();
      System.out.println(key + " " + value);
    }

    for (String value : map.keySet()) {
      System.out.println(value);
    }
  }

}
