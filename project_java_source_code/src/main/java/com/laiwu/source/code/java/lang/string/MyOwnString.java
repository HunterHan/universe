package com.laiwu.source.code.java.lang.string;

import java.util.Arrays;

public class MyOwnString {
  /**
   * 模拟String，构造自己的"String"类
   */

  public char[] value;
  private transient int hash32;
  private int hash;

  MyOwnString(char ac[], boolean flag) {
    hash32 = 0;
    value = ac;
  }

  public MyOwnString() {
    hash32 = 0;
    value = new char[0];
  }

  public MyOwnString concat(MyOwnString s) {
    int i = s.length();
    if (i == 0) {
      return this;
    } else {
      int j = value.length;
      char ac[] = Arrays.copyOf(value, j + i);
      s.getChars(ac, j);
      return new MyOwnString(ac, true);
    }
  }

  public int length() {
    return value.length;
  }

  void getChars(char ac[], int i) {
    System.arraycopy(value, 0, ac, i, value.length);
  }

  public MyOwnString(MyOwnString s) {
    hash32 = 0;
    value = s.value;
    hash = s.hash;
  }

}
