package com.laiwu.source.code.java.util;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerTest {

  public static void main(String[] args) {
    Consumer<String> consumer = name -> System.out.println(name);
    consumer.accept("hanhongtao");

    Function<String, Integer> size = string -> {
      return string.length();
    };
    System.out.println(size.apply("hanhongtao"));

    BiFunction<String, String, String> append = (String a, String b) -> {
      return a + b;
    };
    System.out.println(append.apply("hong", "tao"));
  }
}
