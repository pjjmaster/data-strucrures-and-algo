package com.practice.linkedlist;

public class ModularNode {

  static class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
      this.value = value;
    }
  }
  
  public LisNode getModularNodeFromStart(ListNode head, int k) {
    int count = 0;
    ListNode modularNode = null;
    if(k<=0) {
      return null;
    }
    
    
    while(head != null) {
      if(i%k==0) {
        modularNode = head; 
      }
      count++;      
      head = head.next;
    }  
    return modularNode;
  }
  
  
}
