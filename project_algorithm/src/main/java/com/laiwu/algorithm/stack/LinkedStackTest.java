package com.laiwu.algorithm.stack;

public class LinkedStackTest {
  public static void main(String[] args) {
    LinkedStack<String> stack = new LinkedStack<>();
    boolean isEmpty = stack.isEmpty();
    System.out.println("是否为空:" + isEmpty);

    stack.push("a");
    stack.push("b");
    stack.push("c");
    stack.push("d");

    for (int i = 0; i < stack.size; i++) {
      System.out.println(" " + stack.pop());
    }

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}
