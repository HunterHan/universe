package com.laiwu.source.code.java.virtual.machine.t1;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存溢出，内存不足
 * @author CogniBoy
 *
 */
public class HeapOOM {
  public static void main(String[] args) {
    List<Object> list = new ArrayList<Object>();
    while (true) {
      list.add(new Object());
    }
  }
}
