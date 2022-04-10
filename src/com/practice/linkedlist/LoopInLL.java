package com.practice.linkedlist;

public class LoopInLL {

 Node head;
  
 static class ListNode {

  int data;
  Node next;

  Node(int data) {
    this.data = data;
  }
 }
  
  public boolean hasCycle(ListNode head) {

    if(head==null) {
        return false;
    }    
    ListNode slowPtr = head;
    ListNode fastPtr = head;

    while(fastPtr.next!=null && fastPtr.next.next!=null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
      if(fastPtr.equals(slowPtr)) {
        return true;
      }
    }

    return false;  
  }

        
  
  public Node getFirstNodeOfLoop() {
    if (head == null) {
      return null;
    }

    Node slowPtr = head;
    Node fastPtr = head;
    boolean isLoopPresent = false;

    while (fastPtr.next != null && fastPtr.next.next != null) {
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
      if (fastPtr.equals(slowPtr)) {
        isLoopPresent = true;
        break;
      }
    }
    // Once we find the loop, we move initialize slowPtr head and incerement both of them one
    if (isLoopPresent) {
      slowPtr = head;
      while (slowPtr != fastPtr) {
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next;
      }
      return slowPtr;
    } else {
      return null;
    }
  }

}
