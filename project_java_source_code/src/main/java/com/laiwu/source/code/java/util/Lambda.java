package com.laiwu.source.code.java.util;

import com.laiwu.source.code.StudentBean;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda {

  static List<String> names = Arrays.asList(new String[] { "h", "b", "c" });

  @Test public void test1() {
    String[] datas = new String[] { "han", "zhao", "li" };
    Arrays.sort(datas, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    Stream.of(datas).forEach(param -> System.out.println(param));

    System.out.println(Integer.compare(22, 3));
  }

  @Test public void test2() {
    names.stream().filter((String string) -> {
      if (string.contains("c"))
        return true;
      else
        return false;
    }).forEach(string -> System.out.println(string));
  }

  @Test public void test3() {
    Thread t = new Thread(() -> System.out.print("thread ..."));
    t.start();
  }

  @Test public void test4() {
    Function<String, String> upperFunction = ((String name) -> {
      final String s = name.toUpperCase();
      return s;
    });
    System.out.println(upperFunction.apply("aaa"));
    Stream<String> stringStream = names.stream().map(upperFunction);
    final List<String> upperString = stringStream.collect(Collectors.toList());
    System.out.println(upperString);
  }

  @Test public void test5() {
    Stream.generate(new Supplier<Double>() {
      @Override public Double get() {
        return Math.random();
      }
    }).limit(10).forEach((Double d) -> {
      System.out.println(d);
    });

    Stream.iterate(1, item -> item + 1).limit(10).filter((num) -> {
      return num % 2 == 0;
    }).forEach((num) -> {
      System.out.println(num);
    });
  }

  @Test public void test6() {
    List<String> colors = Arrays.asList("red", "yellow", "green", "red");
    colors.stream().distinct().forEach((String color) -> {
      System.out.println(color);
    });

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1);
    numbers.stream().distinct().forEach((Integer num) -> {
      System.out.println(num);
    });

    StudentBean zhang = new StudentBean(1, "zhang", "male");
    StudentBean qian = new StudentBean(2, "qian", "female");
    List<StudentBean> students = Arrays.asList(zhang, qian);
    List<StudentBean> students2 = Arrays.asList(zhang, qian);

    students.stream().forEach((StudentBean stu) -> {
      System.out.println(stu);
    });

    students2.stream().distinct().forEach((StudentBean student) -> {
      System.out.println(student);
    });
  }

  @Test public void test7() {
    
  }
}
