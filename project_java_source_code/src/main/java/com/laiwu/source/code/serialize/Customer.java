package com.laiwu.source.code.serialize;

public class Customer {
  public static void main(String[] args) {
    Person person = (Person) SerializationUtlis.read();
    System.out.println("对象反序列化成功！");
    System.out.println(person.getName());
    System.out.println(person.getAge());
  }
}
