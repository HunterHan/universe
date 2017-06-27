package com.laiwu.source.code.java.lang;

import org.junit.Test;

public class MyString {

  /**
   * 返回字符串指定索引位置的元素
   */
  @Test
  public void charAt() {
    String str = "北京市东城区";
    char ch = str.charAt(5);
    System.out.println("ch:" + ch);
  }
}
