package com.practice.linkedlist;

public class LinkedList {

	private Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static LinkedList insert(LinkedList list, int data) {

		Node newNode = new Node(data);

		if (list.head == null) {
			list.head = newNode;
		} else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
		return list;
	}


	public static void printList(LinkedList list) {

		Node currentNode = list.head;
		while (currentNode.next != null) {
			System.out.println(currentNode.data + " ");
			currentNode = currentNode.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);
		printList(list);
	}

}
