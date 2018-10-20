package com.laiwu.source.code.apache;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class StringUtilsTest {

  @Test
  public void joinTest() {
    String string = "student";
    Object[] obj = new Object[]{"a", "b", "c"};
    String join = StringUtils.join(obj, "=");
    System.out.println(join);
  }

}
