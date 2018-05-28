package com.laiwu.source.code.java.lang.string;

import com.laiwu.common.util.SimpleDateFormatUtil;

/**
 * String 的 + 在编译器被优化
 * 
 * String string1 = "a" + "b" + "c";
 * 
 * 在编译期间被优化为 String string1 = "abc";
 * 
 */
public class MyString {

  /**
   * hashCode()
   */
  public static void hashCodeTest() {

    String string = new String("asv");
    String string2 = new String("asv");

    System.out.println(string.hashCode());
    System.out.println(string2.hashCode());

    System.out.println();

    Test test1 = new Test();
    test1.setName("testName");
    Test test2 = new Test();
    test2.setName("testName");

    System.out.println(test1.hashCode());
    System.out.println(test2.hashCode());
  }

  /**
   * == 、 + 、 equal()
   */
  public static void equivalence() {

    String a = "abc";
    String b = "def";

    String c = a + b;
    String d = "abc" + "def";
    String e = new String("abc");

    String[] strings = new String[] { a, b, c, d, e };

    for (String string : strings) {
      System.out.println(string);
    }
    System.out.println();
    System.out.println(a == e);
    System.out.println(a.equals(e));
    System.out.println(a == "abc");
    System.out.println(c == "abc" + "def");
    System.out.println(d == "abcdef");
    System.out.println(a == e.intern());
  }

  /**
   * String和StringBuilder速度比较
   */
  public static void speed(int maxCount) {

    System.out.println(String.format("循环添加 %s次", maxCount));
    String name = "";
    long start = System.currentTimeMillis();
    for (int i = 0; i < maxCount; i++) {
      name += i;
    }
    System.out.println("String: \t" + SimpleDateFormatUtil.getDistance(start) + "秒");

    StringBuilder string = new StringBuilder();
    start = System.currentTimeMillis();
    for (int i = 0; i < maxCount; i++) {
      string.append(i);
    }
    System.out.println("StringBuilder: \t" + SimpleDateFormatUtil.getDistance(start) + "秒");
  }

  /**
   * 从指定索引位置查找源String包含目标String的索引位置，如果不存在返回-1，存在则返回目标String在源String中的索引开始位置
   * @param parentString
   * @param fromIndex
   * @param childString
   * @return
   */
  public static int indexOf(String parentString, int fromIndex, String childString) {
    return parentString.indexOf(childString, fromIndex);
  }

  public static boolean matches(String sourceStr, String regStr) {
    return regStr.matches(sourceStr);
  }

  public static String[] split(String sourceStr, String splitStr) {
    String[] strs = sourceStr.split(splitStr);
    return strs;
  }

  /**
   * 返回字符串指定索引位置的元素
   */
  public static char charAt(String str, int index) {
    char ch = str.charAt(index);
    return ch;
  }
}

class Test {
  String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * 类重写object的hashcode()方法,如果不重写的话，具有相同name属性的两个Test对象的hashCode()返回的不相等
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Test other = (Test) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}

