package com.laiwu.algorithm.cache.schedule;

import java.util.LinkedHashMap;

public class LruTest {

  public static void main(String[] args) {

    LinkedHashMap<String, String> map = new LruLinkedHashMap<String, String>(16);
    map.put("a", "a");
    map.put("b", "b");
    map.put("c", "c");
    map.put("a", "a");
    map.put("d", "d");
    map.put("a", "a");
    map.put("b", "b");
    map.put("f", "f");
    map.put("g", "g");

    map.get("d");

    System.out.println(map);


    map.get("a");

    System.out.println(map);

    map.get("c");

    System.out.println(map);

    map.get("b");

    System.out.println(map);

    map.put("h", "h");

    System.out.println(map);

    map.get("d");
  }
}
