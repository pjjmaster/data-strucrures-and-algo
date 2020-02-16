package com.practice.linkedlist;

public class ReversekNodesLinkedListAlternate {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static Node reverseLL(Node head, int k) {

		Node current = head;
		Node previous = null, next = null;
		int count = 0;

		while (current != null && count < k) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			count++;
		}

		if (head != null) {
			head.next = current;
		}

		count = 0;
		while (current != null && count < k - 1) {
			current = current.next;
			count++;
		}

		if (current != null) {
			current.next = reverseLL(current.next, k);
		}

		return previous;
	}

	public static void printList(Node head) {
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;

		printList(reverseLL(head, 3));

	}
}
