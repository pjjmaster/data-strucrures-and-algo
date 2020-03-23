package com.practice.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public List<Integer> getIndicesWithTargetSum(int[] array, int targetSum) {

		// [2, 7, 11, 15]
		// [2, 11, 7, 15]

		int left = 0;
		int right = 0;

		List<Integer> list = new ArrayList<>();

		while (right < array.length && left <= right) {

			int sum = array[left] + array[right];

			if (sum == targetSum) {
				list.add(left);
				list.add(right);
				break;
			} else if (sum > targetSum) {
				left++;
			} else {
				right++;
			}

		}

		return list;
	}

	public boolean isAnagram(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		char[] chars = s.toCharArray();
		Map<Character, Integer> countOfChars = new HashMap<>();

		for (int i = 0; i < chars.length; i++) {

			char c = chars[i];

			int count = countOfChars.getOrDefault(c, 0);

			countOfChars.put(c, count + 1);
		}

		char[] charsOfSecond = t.toCharArray();

		for (int i = 0; i < charsOfSecond.length; i++) {
			char c = charsOfSecond[i];
			if (!countOfChars.containsKey(c)) {
				return false;
			}

			int count = countOfChars.get(c);
			countOfChars.put(c, count--);
		}
		return false;

	}

}
