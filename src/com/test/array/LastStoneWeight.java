package com.test.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public static int getLastStoneWeight(List<Integer> list) {
		if (list.isEmpty()) {
			return 0;
		}

		if (list.size() == 1) {
			return list.get(0);
		}
		list.sort(Comparator.reverseOrder());
		if (list.size() >= 2) {
			int firstElement = list.remove(0);
			int secondElement = list.remove(0);
			int collision = firstElement - secondElement;
			if (collision > 0) {
				list.add(collision);
			}
		}
		return getLastStoneWeight(list);
	}

	public static int optimized(int[] stones) {

		if (null == stones) {
			return 0;
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < stones.length; i++) {
			queue.offer(stones[i]);
		}

		while (queue.size() > 1) {
			int firstElement = queue.poll();
			int secondElement = queue.poll();
			int collision = firstElement - secondElement;
			if (firstElement != secondElement) {
				queue.offer(collision);
			}
		}
		return queue.size() == 1 ? queue.poll() : 0;
	}

	public static void main(String[] args) {

		int[] stones = {2,7,4,1,8,1};
		
		List<Integer> list = new ArrayList<Integer>();
		/*
		 * list.add(2); list.add(7); list.add(4); list.add(1); list.add(8); list.add(1);
		 */
		list.add(1);
		list.add(3);

		//System.out.println("LastStoneWeight.main()" + getLastStoneWeight(list));
		System.out.println("LastStoneWeight.main()" + optimized(stones));

	}

}
