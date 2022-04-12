package com.practice.linkedlist;

class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        
        if(head.next == null) {
            return true;
        }
        
        ListNode middle = getMiddleNode(head);
        ListNode end = reverse(middle);
        ListNode start = head;
        
        while(start!=null && end!=null) {
            if(start.val != end.val) {
                return false;
            }
            start = start.next;
            end = end.next;
        }
        
        return true;
        
    }
    
    public ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        
        while(current!=null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        return previous;
        
    }



}
