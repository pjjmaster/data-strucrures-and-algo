package com.practice.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDupsLL {

	public class Node {
		private int data;
		Node next;

		Node(int data) {
			this.data = data;
		}

	}

	public static void deleteDups(Node node) {
		Map<Integer, Boolean> map = new HashMap<>();
		Node previous = null;
		if (node.next == null) {
			return;
		}

		while (node != null) {
			if (map.containsKey(node.data)) {
				previous.next = node.next;
			} else {
				map.put(node.data, true);
				previous = node;
			}
			node = node.next;
		}
	}

	public static void deleteDupsWithoutMap(Node node) {
		if (node == null || node.next == null) {
			return;
		}

		Node previous = node;
		Node current = node.next;

		while (current != null) {

			Node runner = node;

			while (runner != null) {

				if (current.data == runner.data) {
					Node tmp = current.next;
					previous.next = tmp;
					current = tmp;
					break;
				}
				runner = runner.next;
			}

		}

	}

	public static void main(String[] args) {

	}

}
