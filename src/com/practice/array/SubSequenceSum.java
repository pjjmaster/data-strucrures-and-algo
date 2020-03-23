package com.practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SubSequenceSum {

	static int countSubSequence(List<Integer> inputSeq, int targetSum) {
		if (null == inputSeq || inputSeq.isEmpty()) {
			return 0;
		}

		int size = inputSeq.size();
		int count = 0;
		int currentSum = inputSeq.get(0);

		for (int i = 0; i < size; i++) {

			if (currentSum == targetSum) {
				count++;
				currentSum = 0;
			} else if (currentSum > targetSum) {
				currentSum = inputSeq.get(i);
			} else {
				currentSum += inputSeq.get(i);
			}

		}

		return count;
	}

	static int countSubSequence1(List<Integer> inputSeq, int targetSum) {

		int currentSum = inputSeq.get(0);
		int start = 0;
		int n = inputSeq.size();
		int count = 0;
		for (int i = 1; i <= n; i++) {

			while (currentSum > targetSum && start < i - 1) {
				currentSum -= inputSeq.get(start);
				start++;
			}

			if (currentSum == targetSum) {
				count++;
				continue;
			}
			if (i < n) {
				currentSum += inputSeq.get(i);
			} else {
				return 0;
			}
		}

		return count;
	}

	static int findSubarraySum(List<Integer> inputSeq, int targetSum) {

		int[] array = inputSeq.stream().mapToInt(i -> i).toArray();
		HashMap<Integer, Integer> prevSum = new HashMap<>();

		int n = array.length;

		int res = 0;

		int currsum = 0;

		for (int i = 0; i < n; i++) {

			currsum += array[i];
			if (currsum == targetSum)
				res++;

			if (prevSum.containsKey(currsum - targetSum))
				res += prevSum.get(currsum - targetSum);

			Integer count = prevSum.get(currsum);
			if (count == null)
				prevSum.put(currsum, 1);
			else
				prevSum.put(currsum, count + 1);
		}

		return res;
	}

	public static int getNumberOfSubarraysWithGivenSum(List<Integer> list, int targetSum) {

		if (null == list || list.isEmpty()) {
			return 0;
		}

		int n = list.size();
		int count = 0;
		int left = 0;
		int right = 0;
		int sum = list.get(0);

		while (left < n && right < n) {


			if (sum == targetSum ) {
				count++;
				right++;
				left++;
				sum = 0;
				continue;
			} else if (sum < targetSum) {
				sum = sum + list.get(right);
				right++;
			}

			while (sum > targetSum && left < right) {
				sum = sum - list.get(left);
				left++;
			}

		}

		return count;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(6);
		list.add(2);
		list.add(4);
		list.add(1);
		list.add(5);
		list.add(6);
		System.out.println("SubSequenceSum.main(): " + findSubarraySum(list, 6));

	}

}
