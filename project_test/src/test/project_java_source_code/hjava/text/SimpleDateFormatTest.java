package hjava.text;

import org.junit.Test;

import com.laiwu.source.code.java.text.MySimpleDateFormat;

public class SimpleDateFormatTest {

  @Test
  public void formatterNow() {
    String formatterNow = MySimpleDateFormat.formatNow();
    System.out.println(formatterNow);
  }
}
