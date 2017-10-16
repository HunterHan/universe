package hjava.lang;

import java.util.Arrays;

import org.junit.Test;

import com.laiwu.source.code.java.lang.MyOwnString;
import com.laiwu.source.code.java.lang.MyString;

public class StringTest {

  @Test
  public void myOwnStringTest() {
    MyOwnString str = new MyOwnString();
    str.value = new char[] { 'h', 'a', 'h' };
    MyOwnString str2 = new MyOwnString();
    str2.value = new char[] { 'a', 'h', 'a', 'h', 'a' };
    MyOwnString str3 = str.concat(str2);
    for (int i = 0; i < str3.length(); i++) {
      System.out.print(str3.value[i]);
    }
  }

  @Test
  public void hashCodeTest() {
    MyString.hashCodeTest();
  }

  @Test
  public void equivalenceTest() {
    MyString.equivalence();
  }

  @Test
  public void testSpeed() {
    MyString.speed(100000);
  }

  @Test
  public void indexOf() {
    int index = MyString.indexOf("iponeipad", 6, "ipad");
    System.out.println(index);
  }

  @Test
  public void matches() {
  }

  @Test
  public void splitTest() {
    String[] split = MyString.split("11111a2222a3333", "a");
    Arrays.asList(split).forEach(one -> System.out.println(one));
    System.out.println(Arrays.toString(split));
  }

  @Test
  public void charAtTest() {
    char ch = MyString.charAt("ipad", 2);
    System.out.println(ch);
  }

}
