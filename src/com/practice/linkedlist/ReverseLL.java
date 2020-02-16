package com.practice.linkedlist;

public class ReverseLL {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node reverse(Node head) {

		Node currentNode = head;
		Node previousNode = null;
		Node nextNode = null;

		while (currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}

		return previousNode;
	}

	public static Node reverse(Node head, int k) {

		Node currentNode = head;
		Node previousNode = null;
		Node nextNode = null;

		int count = 0;

		while (count < k && currentNode != null) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
			count++;
		}

		if (nextNode != null) {
			head.next = reverse(nextNode, k);
		}

		return previousNode;
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
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		//printList(head);
		printList(reverse(head,3));

	}

}
