package jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import com.laiwu.source.code.java.virtual.machine.t3.JConsoleJstack;

public class JConsoleJstackTest {
  @Test
  public void jConsoleJstackTest() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    JConsoleJstack.createBusyThread();
    br.readLine();
    Object obj = new Object();
    JConsoleJstack.createLockThread(obj);
  }
}
