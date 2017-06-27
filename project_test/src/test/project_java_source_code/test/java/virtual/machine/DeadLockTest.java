package test.java.virtual.machine;

import org.junit.Test;

import com.laiwu.source.code.java.virtual.machine.t3.DeadLock;

public class DeadLockTest {
  @Test
  public void deadLockTest() {

    for (int i = 0; i < 100; i++) {
      new Thread(new DeadLock.SyncAddRunable(1, 2)).start();
      new Thread(new DeadLock.SyncAddRunable(2, 1)).start();
    }
  }
}
