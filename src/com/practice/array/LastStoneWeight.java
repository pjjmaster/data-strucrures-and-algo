package com.practice.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the smallest possible weight of the left stone. If there are no stones left, return 0.

 

Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
Example 2:

Input: stones = [1]
Output: 1

*/

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
