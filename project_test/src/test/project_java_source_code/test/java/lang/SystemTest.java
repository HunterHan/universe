package test.java.lang;

import org.junit.Test;

import com.laiwu.source.code.java.lang.MySystem;

public class SystemTest {

  @Test
  public void getCurrentTimeMillisTest() {
    MySystem.compareTimePrecision();
  }

  @Test
  public void arrayCopyTest() {
    MySystem.arrayCopy();
  }
}
