package com.practice.linkedlist;

public class MergeKLists {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {

		if (lists.length == 0) {
			return null;
		}

		return divideAndConquer(lists, 0, lists.length - 1);
	}

	private static ListNode divideAndConquer(ListNode[] lists, int start, int end) {

		if (start < end) {
			int mid = start + end / 2;
			ListNode node1 = divideAndConquer(lists, start, mid);
			ListNode node2 = divideAndConquer(lists, mid + 1, end);
			return mergeLists(node1, node2);
		}

		return lists[start];
	}

	public static ListNode mergeLists(ListNode node1, ListNode node2) {

		if (node1 == null) {
			return node2;
		} else if (node2 == null) {
			return node1;
		} else if (node1.val > node2.val) {
			node2.next = mergeLists(node1, node2.next);
			return node2;
		} else {
			node1.next = mergeLists(node1.next, node2);
			return node1;
		}

	}

	static void printList(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public static void main(String[] args) {

		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(5);
		head1.next.next.next = new ListNode(7);

		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(6);
		head2.next.next.next = new ListNode(8);

		ListNode head3 = new ListNode(0);
		head2.next = new ListNode(9);
		head2.next.next = new ListNode(10);
		head2.next.next.next = new ListNode(11);

		ListNode[] lists = { head1, head2, head3 };

		ListNode response = mergeKLists(lists);

		printList(response);
	}

}
