package com.test.array;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class KthLargest {

	int k = 0;
	PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

	public KthLargest(int k, int[] nums) {
		this.k = k;
		for (int i = 0; i < nums.length; i++) {
			queue.offer(nums[i]);
		}
	}

	public int add(int val) {
		queue.offer(val);
		int j = 0;
		int result = -1;
		Iterator<Integer> itr = queue.iterator();
		
		while (itr.hasNext() && j < k) {
			result = itr.next();
			j++;
		}

		return result;
	}

	public static void main(String[] args) {

		int k = 3;
		int[] arr = { 4, 5, 8, 2 };
		KthLargest kthLargest = new KthLargest(3, arr);
		System.out.println(kthLargest.add(3)); // returns 4
		System.out.println(kthLargest.add(5)); // returns 5
		System.out.println(kthLargest.add(10)); // returns 5
		System.out.println(kthLargest.add(9)); // returns 8
		System.out.println(kthLargest.add(4)); // returns 8

	}

}
