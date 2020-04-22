package com.practice.linkedlist;

public class PalindromeLL {
	/*
	 * Check if given number represented as linked list is palindrome or not
	 * Ex:
	 *  1 -> 2-> 3-> 4 -> 3-> 2-> 1
	 */
	
	
	static class Node {
		Node next;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	public static boolean isPalindrome(Node head) {

		// 1 -> 2-> 3-> 4 -> 3-> 2-> 1
		if (head == null) {
			return false;
		}

		Node slowPtr = head;
		Node fastPtr = head;
		Node slowPtrPrev = head;
		Node midNode = null;
		Node secondHalf = null;

		if (head != null && head.next != null) {

			while (fastPtr != null && fastPtr.next != null) {
				fastPtr = fastPtr.next.next;
				slowPtrPrev = slowPtr;
				slowPtr = slowPtr.next;
			}

			if (fastPtr != null) {
				midNode = slowPtr;
				slowPtr = slowPtr.next;
			}

			secondHalf = slowPtr;
			slowPtrPrev.next = null;

			Node last = reverseLL(secondHalf);

			while (head != null && last != null) {

				if (head.data == last.data) {
					head = head.next;
					last = last.next;
				} else {
					return false;
				}

			}
			if (null == head && null == last) {
				return true;
			}

		}
		return false;
	}

	private static Node reverseLL(Node head) {

		Node previous = null;

		Node next = null;
		Node current = head;

		while (current != null) {

			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		return previous;
	}

	public static void main(String[] args) {

		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(3);
		Node six = new Node(2);
		Node seven = new Node(1);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		boolean condition = isPalindrome(one);
		System.out.println("isPalidrome :" + condition);

	}

}
