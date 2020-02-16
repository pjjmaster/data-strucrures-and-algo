package com.practice.linkedlist;

public class IncrementLL {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node newNode(Node node) {
		Node newNode = new Node(node.data);
		return newNode;
	}

	public static int addWithCarry(Node head) {

		if (head == null) {
			// adding 1 to last digit
			return 1;
		}

		int result = head.data + addWithCarry(head.next);

		head.data = result % 10;

		return result / 10;

	}

	public static Node addOne(Node head) {
		
		int carry = addWithCarry(head);
		
		if(carry>0) {
			Node newNode = new Node(carry);
			newNode.next = head;
			return newNode;
		}
		
		return head;
	}

	public static void main(String[] args) {

		Node head = new Node(9);
		head.next = new Node(9);
		head.next.next = new Node(9);
		head.next.next.next = new Node(9);

		System.out.print("List is ");
		printList(head);
		
		Node revisedHead = addOne(head);
		printList(revisedHead);
	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data);
			node = node.next;
		}
		System.out.println();
	}
}
