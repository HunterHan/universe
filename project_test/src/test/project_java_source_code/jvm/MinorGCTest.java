package jvm;

import org.junit.Test;

import com.laiwu.source.code.java.virtual.machine.t2.MinorGC;

public class MinorGCTest {

  @Test
  public void minorGCTest() {
    MinorGC.process();
  }
}
