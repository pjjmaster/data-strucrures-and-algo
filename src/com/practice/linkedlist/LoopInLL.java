package com.practice.linkedlist;

public class LoopInLL {

  Node head;
  
 static class Node {

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

        

  
  
  
  
}
