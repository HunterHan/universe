package com.laiwu.algorithm.stack;

public class LinkedStack<T> {

  private class Node {
    T data;
    Node next;
  }

  public int size = 0;
  private Node first = null;

  public boolean isEmpty() {
    return first == null;
  }

  public void push(T data) {

    Node oldItem = first;
    first = new Node();
    first.data = data;
    first.next = oldItem;

    size ++;
  }

  public T pop() {
    if(first == null)
      return null;
    T data = first.data;
    first = first.next;
    return data;
  }

  public static void main(String[] args) {
    LinkedStack<String> stack = new LinkedStack<>();
    boolean isEmpty = stack.isEmpty();
    System.out.println("是否为空:" + isEmpty);

    stack.push("a");
    stack.push("b");
    stack.push("c");
    stack.push("d");

    for (int i = 0; i < stack.size; i++) {
      System.out.println(stack.pop());
    }

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

}
