package jvm;

import org.junit.Test;

import com.laiwu.source.code.java.virtual.machine.t2.ReferenceCountingGC;

public class ReferenceCountingGCTest {

  @Test
  public void referenceCountingGCTest() {
    ReferenceCountingGC.gc();
  }
}
