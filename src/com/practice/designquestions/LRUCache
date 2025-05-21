package com.practice.designquestions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    /**
     * Implemented using hashMap and doubly linked list which maintains the head and tail
     * 1. put: add elements to map and move the node at the start of list. If size is equal to capacity, then remove from tail
     * 2. get: get from the map and if it exists in the map, move it to the start of the list and remove from original position
     */
    Map<K, Node> cache = new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // Create dummy head and tail and insert the elements in between.
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node node = cache.get(key);
        if (node == null) {
            return null;
        } else {
            moveToFront(node);
            return node.value;
        }
    }

    private void moveToFront(Node node) {
        remove(node);
        insertToStart(node);
    }

    private void insertToStart(Node node) {
        // Update the next of node to be head's next
        node.next = head.next;
        // Update previous of node to head node
        node.prev = head;

        // Now update the original head to point to new node
        head.next.prev = node;
        head.next = node;
    }

    public void put(K key, V value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToFront(node);
        } else {
            Node newNode = new Node(key, value);
            insertToStart(newNode);
            if (cache.size() >= capacity) {
                evictFromTail();
            }
            cache.put(key, newNode);
        }
    }

    private void evictFromTail() {
        Node lastNode = tail.prev;
        cache.remove(lastNode.key);
        remove(lastNode);
    }


    private void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void printCache() {
        Node curr = head.next;
        while (curr.next != null){
            System.out.print("(" + curr.key + ":" + curr.value + ") ");
            curr = curr.next;
        }
        System.out.println();
    }

    class Node {
        K key;
        V value;
        Node next;
        Node prev;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");
        cache.printCache(); // (3:C) (2:B) (1:A)

        cache.get(1); // Access 1, makes it most recently used
        cache.printCache(); // (1:A) (3:C) (2:B)

        cache.put(4, "D"); // Evicts 2
        cache.printCache(); // (4:D) (1:A) (3:C)
    }

}
