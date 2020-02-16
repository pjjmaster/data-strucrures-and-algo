package com.test.array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianForDataStream {

	// iF NUMBER IS GREATER THEN MIN.POP()
	// ADD IT TO mINhEAP
	// ELSE ADD IT OT MAX HEAP

	// IF SIZE OF MAX HEAP IS GREATER THAN MIN HEAP

	private Queue<Long> small = new PriorityQueue<>(Comparator.reverseOrder());
	private Queue<Long> large = new PriorityQueue<>();

	public void addNum(int number) {
		if (large.isEmpty() && small.isEmpty()) {

		}

		large.add((long) number);
		if (large.size() > small.size() + 1) {
			
		}

	}

	/*
	 * public void addNum(int num) { large.add((long) num);
	 * small.add(-large.poll()); if (large.size() < small.size())
	 * large.add(-small.poll()); }
	 */

	public double findMedian() {
		return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
	}

	public static void main(String[] args) {
		int[] array = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		MedianForDataStream median = new MedianForDataStream();
		for (int i = 0; i < array.length; i++) {
			median.addNum(array[i]);
			System.out.println("MedianForDataStream.main():" + median.findMedian());
		}

	}

}
