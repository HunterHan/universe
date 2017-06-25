package com.laiwu.source.code.java.virtual.machine.t3;

import java.util.ArrayList;
import java.util.List;

public class JConsoleJstatMonitor {

  static class OOMObject {
    // 内存占位符，一个OOMObject大约占64k
    public byte[] placeholder = new byte[64 * 1024];
  }

  public static void fillHeap(int num) throws InterruptedException {
    List<OOMObject> list = new ArrayList<OOMObject>();
    for (int i = 0; i < num; i++) {
      // 稍作延时，令监事曲线的变化更加明显
      Thread.sleep(50);
      list.add(new OOMObject());
    }
  }
}
