package com.laiwu.source.code.classloader;

public class People {

  private String name;

  private Integer age;

  public Integer getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "my name is " + name;
  }
}
