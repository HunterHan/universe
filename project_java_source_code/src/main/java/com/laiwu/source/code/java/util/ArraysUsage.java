package com.laiwu.source.code.java.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ArraysUsage {

  @Test
  public void asList() {
    String[] names = { "tom", "jack", "peter" };
    System.out.println(Arrays.asList(names));

    Arrays.sort(names);
    System.out.println(Arrays.asList(names));
  }

}
