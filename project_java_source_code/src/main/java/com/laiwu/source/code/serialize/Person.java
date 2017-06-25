package com.laiwu.source.code.serialize;

import java.io.Serializable;

public class Person implements Serializable {

  // private static final long serialVersionUID = 55799L;
  // 显式声明serialVersionUID可以避免对象不一致但尽量不要以这种方式对JVM 说谎

  private String name;

  private int age;

  public Person() {
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
