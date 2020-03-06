package com.practice.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKArrays {

	public static List<Integer> mergeKSortedArrays(List<List<Integer>> sortedArrays) {

		List<Iterator<Integer>> iterators = new ArrayList<Iterator<Integer>>(sortedArrays.size());

		// Get iterators of each list to keep track of index
		for (List<Integer> list : sortedArrays) {
			iterators.add(list.iterator());
		}

		Queue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrays.size(),
				(o1, o2) -> Integer.compare(o1.value, o2.value));
		
		for (int i = 0; i < iterators.size(); i++) {
			if (iterators.get(i).hasNext()) {
				minHeap.offer(new ArrayEntry(iterators.get(i).next(), i));
			}
		}

		List<Integer> result = new ArrayList<>();

		while (!minHeap.isEmpty()) {
			// Pop the minimum number
			ArrayEntry entry = minHeap.poll();

			result.add(entry.value);

			if (iterators.get(entry.arrayId).hasNext()) {
				minHeap.offer(new ArrayEntry(iterators.get(entry.arrayId).next(), entry.arrayId));
			}

		}

		return result;
	}

	static class ArrayEntry {
		Integer value;
		Integer arrayId;

		public ArrayEntry(Integer value, Integer arrayId) {
			this.value = value;
			this.arrayId = arrayId;
		}
	}

	public static void main(String[] args) {

		int arr[][] = { { 1, 3, 5, 7 }, { 2, 4, 6, 8 }, { 0, 9, 10, 11 } };

		int[] arr1 = { 1, 3, 5, 7 };

	}

}
