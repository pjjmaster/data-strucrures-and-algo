package com.practice.linkedlist;  

public class IntersectionOfLists {


     static class ListNode {
         int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
  
      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Calculate the size of both lists
        int sizeA = 0;
        ListNode temp = headA;
        while(temp!=null) {
            temp = temp.next;
            sizeA++;
        }
        
        temp = headB;
        int sizeB = 0;
        while(temp!=null) {
            temp = temp.next;
            sizeB++;
        }
        
        // In the longer list move (sizeA-sizeB) nodes
        int diff = sizeA -sizeB;
        if(diff < 0) {
            diff = Math.abs(diff);
            while(diff > 0) {
                diff--;
                headB = headB.next;
            }
        } else {
            while(diff >0) {
                diff --;
                headA = headA.next;
            }
        }
        
        // Move both pointers one 
        while(headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
        
    }


}
