package com.practice.linkedlist;

/*
Given a Linked List of integers, write a function to modify the linked list such that all even numbers appear before all the odd numbers in the modified linked list. 
Also, keep the order of even and odd numbers same.

*/


class SeggregateEvenAndOdd {

      public ListNode oddEvenList(ListNode head) {

        ListNode currentNode = head;
        ListNode evenStart = null, evenEnd = null;
        ListNode oddStart = null, oddEnd = null;
        
        while(currentNode != null) {
            
            if(currentNode.val%2 !=0 ) {
                // Odd number
                if(oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                } else {                
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            } else {
                if(evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;    
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;   
                }
            }
            currentNode = currentNode.next;   
        }
        
        oddEnd.next = evenStart;
        evenEnd.next = null;
        return oddStart;
    }


}
