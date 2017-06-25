package com.laiwu.source.code.java.virtual.machine.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池溢出，常量池内存不足
 * @author CogniBoy
 *
 */
public class RuntimeConstantPoolOOM {
  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    int i = 0;
    while (true) {
      list.add(String.valueOf(i++).intern());
    }
  }
}
