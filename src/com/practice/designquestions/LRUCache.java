package com.practice.designquestions;

import java.util.HashMap;

public class LRUCache {

	class Node {
		Integer key;
		Integer value;

		Node previous;
		Node next;
	}

	HashMap<Integer, Node> map = new HashMap<>();
	int totalItemsInCache = 0;
	int maxCapacity;
	Node head;
	Node tail;

	public LRUCache(int capacity) {
		this.maxCapacity = capacity;

		head = new Node();
		tail = new Node();

		head.next = tail;
		tail.previous = head;
	}

	public Integer get(int key) {

		Node node = map.get(key);
		if (node == null) {
			return null;
		}

		moveToHead(node);
		return node.value;
	}

	public void put(int key, int value) {
		Node node = map.get(key);

		if (node == null) {
			Node newNode = new Node();
			newNode.key = key;
			newNode.value = value;
			map.put(key, newNode);
			addToFront(newNode);
			totalItemsInCache++;

			if (totalItemsInCache > maxCapacity) {
				removeLRUEntry();
			}
		} else {
			node.value = value;
			moveToHead(node);
		}
	}

	private void removeLRUEntry() {

		Node tail = popTail();
		map.remove(tail.key);
		--totalItemsInCache;
	}

	private Node popTail() {
		Node tailItem = tail.previous;
		removeFromList(tailItem);
		return tailItem;
	}

	private void moveToHead(Node node) {
		removeFromList(node);
		addToFront(node);
	}

	private void removeFromList(Node node) {

		Node savedPrev = node.previous;
		Node savedNext = node.next;

		savedPrev.next = savedNext;
		savedNext.previous = savedPrev;

	}

	private void addToFront(Node node) {
		node.previous = head;
		node.next = head.next;

		head.next.previous = node;
		head.next = node;

	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(5);

		cache.put(1, 10);
		cache.put(2, 10);
		cache.put(3, 30);
		cache.put(4, 40);
		cache.put(1, 10);
		cache.put(5, 50);

		cache.get(5);
		cache.get(4);

		cache.put(6, 60);
		cache.put(7, 70);
		cache.put(8, 80);
	}

}
