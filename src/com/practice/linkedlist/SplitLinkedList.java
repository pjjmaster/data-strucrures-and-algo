package com.practice.linkedlist;

class SplitLinkedList {

  static class ListNode {

    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }

  
  public void splitLinkedListIntoHalves(ListNode head) {
  
    ListNode slow = head;
    ListNode fast = head;
    
    while(fast.next!=head || fast.next.next!=head) {
      slow = slow.next;
      fast = fast.next.next;
    }
    
    // If event number of nodes then fast pointer will be pointing to last but one node
    if(fast.next.next = head) {
      fast= fast.next;
    }
    ListNode head1 = head;
    ListNode head2 = slow.next;
    slow.next = head1;
    fast.next = head2;    
  }
  
  
}
