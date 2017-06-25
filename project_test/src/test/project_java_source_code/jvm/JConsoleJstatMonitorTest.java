package jvm;

import org.junit.Test;

import com.laiwu.source.code.java.virtual.machine.t3.JConsoleJstatMonitor;

public class JConsoleJstatMonitorTest {

  @Test
  public void jConsoleJstatMonitorTest() throws InterruptedException {
    JConsoleJstatMonitor.fillHeap(1500);
    System.gc();
  }
}
