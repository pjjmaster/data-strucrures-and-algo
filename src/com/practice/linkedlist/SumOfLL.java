package com.practice.linkedlist;

public class SumOfLL {

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	public static Node sum(Node first, Node second) {

		Node result = null;
		Node previous = null;
		Node temp = null;

		int sum = 0;
		int carry = 0;

		while (first != null && second != null) {

			sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);

			carry = sum / 10;

			sum = sum % 10;

			temp = new Node(sum);

			if (result == null) {
				result = temp;
			} else {
				previous.next = temp;
			}

			previous = temp;

			if (first != null) {
				first = first.next;
			}

			if (second != null) {
				second = second.next;
			}

			if (carry > 0) {
				temp.next = new Node(carry);
			}

			return result;
		}

		return new Node(1);
	}

	public static void main(String[] args) {

	}

}
