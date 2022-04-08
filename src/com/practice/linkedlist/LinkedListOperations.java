package com.practice.linkedlist;  

public class LinkedListOperations {

  private Node head;
  
  static class Node {
    int data;
    Node next;
    
    Node(int data) {
      this.data = data;
    }
  }
  
  public static Node insert(int data, int position){
    int count = 1;
    Node newNode = new Node(data);
    if(head==null) {
      newNode.next = null;
      this.head = newNode;
    }
    
    // Check if we want to add at start of the list
    else if(position=1) {
      newNode.next = head;
      head = newNode;
    } else {
      Node temp = head;
      while(temp.next!=null && count=position) {
        temp = temp.next;
        count++;        
      }
      
    
    }
    
  
  }


}
