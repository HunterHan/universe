package com.laiwu.source.code.string;

import org.junit.Test;

/**
 * 【String的官方API练习】
 * @author CogniBoy
 *
 */
public class StringAPI {

  @Test
  public void indexOf() {
    String string = "abcdabcd";
    System.out.println(string.indexOf("a", 2));
  }

  @Test
  public void matches() {
    String regShanDong = "^3700\\d+";
    String regNum = "3700001902730";
    System.out.println(regNum.matches(regShanDong));
  }

  @Test
  public void split() {
    String testString = "123abc456abc789";
    String[] strs = testString.split("abc");
    for (int i = 0; i < strs.length; i++) {
      System.out.println(strs[i]);
    }
  }
}
