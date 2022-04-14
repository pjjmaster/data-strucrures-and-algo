package com.practice.linkedlist;

public class SquareRootNode {

   static class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
      this.value = value;
    }
  }
  
  
  public ListNode getSquareRootNode(ListNode head) {
    
    if(head == null) {
      return null;
    }
    
    int i=1; j=1;
    ListNode squareRootNode= null;
    
    while(head != null) {
    
      if(i == j*j) {
        if(squareRootNode == null) {
          squareRootNode = head;
        } else {
          squareRootNode = squareRootNode.next;
        }
        j++;
      }
      i++;
      head = head.next;
    }
    return squareRootNode;  
  }
  
}
