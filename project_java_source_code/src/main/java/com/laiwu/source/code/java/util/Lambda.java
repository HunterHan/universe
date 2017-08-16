package com.laiwu.source.code.java.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {

  static List<String> names = Arrays.asList(new String[]{"h", "b", "c"});

  @Test public void test1() {
    String[] datas = new String[] { "han", "zhao", "li" };
    Arrays.sort(datas, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    Stream.of(datas).forEach(param -> System.out.println(param));

    System.out.println(Integer.compare(22, 3));
  }
  @Test
  public void test2(){
    //names.forEach(string -> System.out.println(string));
    names.stream().filter(string -> string.contains("c")).forEach(string -> System.out.println(string));
    names = Arrays.asList(new String[]{"h", "b", "c"});
  }

  @Test
  public void test3(){
    Thread t = new Thread(() -> System.out.print("thread ..."));
    t.start();
  }

  @Test
  public void test4(){
    Function<String, String> upperFunction = name -> {
      final String s = name.toUpperCase();
      return s;
    };
    System.out.println(upperFunction.apply("aaa"));
    Stream<String> stringStream = names.stream().map(upperFunction);
    final List<String> upperString = stringStream.collect(Collectors.toList());
    System.out.println(upperString);
  }
}
