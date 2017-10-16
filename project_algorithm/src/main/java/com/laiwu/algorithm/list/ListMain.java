package com.laiwu.algorithm.list;

import org.junit.Test;

public class ListMain {

  @Test
  public void fastSlow() {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node1;

    boolean flag = SearchCycleNode.hasCycle(node1);
    System.out.println(flag);

  }

  @Test
  public void steps() {

    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node2;

    ListNode listNode = SearchCycleNode.detectCycle(node1);

    System.out.println(listNode);

  }

}


