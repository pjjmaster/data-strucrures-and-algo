package com.practice.linkedlist;

public class NthNodeFromTail {

  Node head;  
  
  static class Node {

    int data;
    Node next;

    Node(int data) {
      this.data = data;
    }
  }


  public void printLL() {
    Node node = head;
    if (node != null) {
      System.out.print(node.data + "-->");
    }
    while (node.next != null) {
      node = node.next;
      System.out.print(node.data + "-->");
    }
  }

  private void insert(int data) {
    Node newNode = new Node(data);
    Node tmp = head;
    while (tmp.next != null) {
      tmp = tmp.next;
    }
    tmp.next = newNode;
  }

  private Node getNLastNode(int n) {
    if(n<0) {
      return head;
    }
    Node firstNode = head;
    Node secondNode = head;
    int count = 1;
    while (count < n) {
      firstNode = firstNode.next;
      count++;
    }
    // If given n is greater than length of list, we should return head
    while (firstNode!=null && firstNode.next != null) {
      secondNode = secondNode.next;
      firstNode = firstNode.next;
    }
    return secondNode;
  }

    public static void main(String[] args) {
    int head = 1;
    LinkedListOperations operations = new LinkedListOperations(head);
    operations.insert(2);
    operations.insert(3);
    operations.insert(4);
    operations.insert(5);
    operations.insert(6);

    operations.printLL();
    Node node = operations.getNLastNode(7);
    System.out.println("\n" + node.data);
  }

  
  
  

}
