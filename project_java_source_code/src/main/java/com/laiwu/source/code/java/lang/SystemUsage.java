package com.laiwu.source.code.java.lang;

import org.junit.Test;

import com.laiwu.source.code.java.util.ArraysUsage;

public class SystemUsage {

  @Test
  public void arrayCopy() {
    String[] names = { "tom", "jack", "peter" };
    String[] dest = new String[names.length];
    System.arraycopy(names, 0, dest, 0, names.length);
    ArraysUsage.printArray(dest);
  }
}
