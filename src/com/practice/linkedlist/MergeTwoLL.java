package com.practice.linkedlist;

public class MergeTwoLL() {

    // Iterative approach
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1==null) {
            return list2;
        }
        if(list2==null) {
            return list1;
        }
        
        // Create a temp holder node
        ListNode temp = new ListNode(-1);
        // Node to keep track of head
        ListNode ans = temp;
        
        while(list1!=null && list2!=null) {
            
            if(list1.val < list2.val) {            
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
              
        }
        
        while(list1!=null) {
            temp.next = list1;
            temp = temp.next;
            list1 = list1.next;
        }
        
        while(list2!=null) {
            temp.next = list2;
            temp = temp.next;
            list2 = list2.next;
        }
        // we should ignore the first temp node 
        return ans.next;
        
    }
  
  // Recursive approach
  
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

      if(list1==null) {
          return list2;
      }
      if(list2==null) {
          return list1;
      }

      if(list1.val < list2.val) {
          list1.next = mergeTwoLists(list1.next, list2);
          return list1;
      } else {
          list2.next = mergeTwoLists(list1, list2.next );
          return list2;
      }


    }
  


}
