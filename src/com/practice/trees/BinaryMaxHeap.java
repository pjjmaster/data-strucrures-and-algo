package com.practice.trees;

import java.util.Arrays;

public class BinaryMaxHeap {

	private int heapSize;
	private int[] heap;

	public BinaryMaxHeap(int capcity) {
		heapSize = 0;
		heap = new int[capcity + 1];
		Arrays.fill(heap, -1);
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public int kthChild(int i, int k) {
		return (2 * i) + k;
	}

	public void insert(int value) {
		// if full return error
		heap[heapSize++] = value;

		heapifyUp(heapSize - 1);
	}

	private void heapifyUp(int i) {

		int temp = heap[i];

		while (i >= 0 && heap[i] > heap[parent(i)]) {
			heap[i] = heap[parent(i)];
			i = parent(i);
		}
		heap[i] = temp;
	}

	public static void main(String[] args) {

	}

}
