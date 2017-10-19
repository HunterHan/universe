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
    T data = first.data;
    first = first.next;
    return data;
  }

}
