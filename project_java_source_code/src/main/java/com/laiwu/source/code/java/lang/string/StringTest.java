package com.laiwu.source.code.java.lang.string;

import com.google.common.collect.Lists;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class StringTest {

  public static void main(String[] args) {

    String string = new String("hanhongtaoabcdefghijklmnopqrstuvwxyz");
    byte[] bytes = string.getBytes();
    for (byte b : bytes)
      System.out.println(b);


    String newString = new String("HANHONGTAO");
    System.out.println(string.equalsIgnoreCase(newString));

    System.out.println(string.startsWith("t", 7));

    System.out.println(string.endsWith("tao"));

    int i = string.indexOf(62);
    char ch = (char) i;
    System.out.println(i);
    System.out.println(ch);

    System.out.println(string.substring(10));
    System.out.println(string.contains("abc"));

    String[] split = string.split("abc");
    for (String s : split)
      System.out.println(s);

    System.out.println(String.join("hanhongtao", "hanhongtaoabcdefghijklmnhanhongtaoopqrstuvwxyz"));

    System.out.println(Locale.getDefault());

    System.out.println(" h h ".trim());

    String intern1 = "test".intern();
    String intern2 = "test".intern();
    System.out.println(intern1 == intern2);

    String str1 = new StringBuilder("计算机").append("软件").toString();
    // String str3= new StringBuilder("计算机软件").toString();
    System.out.println(str1.intern() == str1);
    String str2 = new StringBuilder("Java(TM) SE ").append("Runtime Environment").toString();
    System.out.println(str2.intern() == str2);

//    Object obj = new Integer(100);
//    String strVal = (String)obj;

    Object obj = null;
    String s = String.valueOf(obj);
    System.out.println(s == null);
    System.out.println(s.toString());
//    System.out.println(obj.toString()); 空指针异常

    List<String> list = Lists.newArrayList(
        "bcd", "cde", "def", "abc");
    List<String> result = list.stream()
        //.parallel()
        .filter(e -> e.length() >= 3)
        .map(e -> e.charAt(0))
        //.peek(System.out :: println)
        //.sorted()
        //.peek(e -> System.out.println("++++" + e))
        .map(e -> String.valueOf(e))
        .collect(Collectors.toList());
    System.out.println("----------------------------");
    System.out.println(result);

  }
}
