package com.laiwu.source.code.Stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreamTest {

  public static void main(String[] args) {

    List<Student> list = new ArrayList<>();
    initList(list);

    // 外部迭代 迭代过程通过显式调用Iterator对象的hasNext和next方法完成迭代
    outerIterator(list);

    innerIterator(list);

  }

  private static void innerIterator(List<Student> list) {
    // 返回内部迭代中的相应接口： Stream
    // 这种迭代方式称为内部迭代
    list.stream()
            .filter(student -> student.getSex().equals("G"))
            .forEach(student -> System.out.println(student.toString()));
  }

  private static void outerIterator(List<Student> list) {
    Iterator<Student> iterator = list.iterator();
    while (iterator.hasNext()) {
      Student stu = iterator.next();
      if (stu.getSex().equals("G")) {
        System.out.println(stu.toString());
      }
    }
  }

  private static void initList(List<Student> list) {
    Student stuA = new Student(1, "A", "M", 184);
    Student stuB = new Student(2, "B", "G", 163);
    Student stuC = new Student(3, "C", "M", 175);
    Student stuD = new Student(4, "D", "G", 158);
    Student stuE = new Student(5, "E", "M", 170);

    list.add(stuA);
    list.add(stuB);
    list.add(stuC);
    list.add(stuD);
    list.add(stuE);
  }

}
