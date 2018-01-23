package com.laiwu.source.code.java.util;


import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MyCollections {

  static LinkedList<Integer> linkedList = new LinkedList<Integer>();
  static {
    linkedList.add(new Integer(4));
    linkedList.add(new Integer(2));
    linkedList.add(new Integer(3));
    linkedList.add(new Integer(1));
    linkedList.add(new Integer(5));
  }

  @Test
  public void reverse() {

    System.out.println(linkedList);

    Comparator<Integer> comparator = Collections.reverseOrder();
    Collections.sort(linkedList, comparator);

    System.out.println(linkedList);
  }

  @Test
  public void shuffle() {
    Collections.shuffle(linkedList);
    System.out.println(linkedList);
  }

  @Test
  public void max() {
    System.out.println(Collections.max(linkedList));
    System.out.println(Collections.min(linkedList));
  }
}
