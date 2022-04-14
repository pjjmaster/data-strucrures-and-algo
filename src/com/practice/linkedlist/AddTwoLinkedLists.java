package com.practice.linkedlist;
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*/


class AddTwoLinkedLists {


      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode h1 = l1;
        ListNode h2 = l2;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while(h1 != null || h2 != null) {
            int x = h1 != null ? h1.val : 0;
            int y = h2 != null ? h2.val : 0;
            int sum = carry + x + y;
            carry = sum/10;
            current.next = new ListNode(sum % 10); 
            current = current.next;
            if(h1 != null) {
               h1 = h1.next;
            }
            if(h2 != null) {
               h2 = h2.next; 
            }
            
        }
        
        if(carry != 0) {
            current.next = new ListNode(carry);
        }
     
        return dummy.next;
    }


}
