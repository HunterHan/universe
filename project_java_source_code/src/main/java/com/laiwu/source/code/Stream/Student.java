package com.laiwu.source.code.Stream;

public class Student {
  private int no;
  private String name;
  private String sex;
  private float height;

  public Student(int no, String name, String sex, float height) {
    this.no = no;
    this.name = name;
    this.sex = sex;
    this.height = height;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public float getHeight() {
    return height;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "Student{" +
            "no=" + no +
            ", name='" + name + '\'' +
            ", sex='" + sex + '\'' +
            ", height=" + height +
            '}';
  }
}
