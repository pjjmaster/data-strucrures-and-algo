package com.practice.linkedlist;

public class MergeTwoList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val > l2.val) {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		} else {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
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

		ListNode head2 = new ListNode(2);
		head2.next = new ListNode(4);
		head2.next.next = new ListNode(6);

		ListNode resp = mergeTwoLists(head1, head2);
		printList(resp);
	}

}
