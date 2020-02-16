package com.test.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairWithSum {

	public static void printPairs(int[] array, int sum) {
		Set set = new HashSet(array.length);
		for (int number : array) {
			int target = sum - number;

			if (set.contains(target)) {
				System.out.printf("(%d, %d) %n", number, target);
			} else {
				set.add(number);
			}
		}
	}

	public static int[] printPairsUsingTwoPointers(int[] array, int exptectedSum) {

		int [] result = new int[2];

		if (array.length < 2) {
			return result;
		}

		Arrays.sort(array);

		int left = 0;
		int right = array.length - 1;
		while (left < right) {

			int sum = array[left] + array[right];
			if (sum == exptectedSum) {
				System.out.printf("(%d, %d) %n", array[left], array[right]);
				result[0] = left;
				result[1] = right;
				left++;
				right--;
			} else if (sum < exptectedSum) {
				left++;
			} else if (sum > exptectedSum) {
				right--;
			}
		}
		
		return result;

	}

	public int[] twoSum(int[] nums, int target) {

		int arraySize = nums.length;

		if (arraySize < 2) {
			return null;
		}

		int left = 0;
		int right = arraySize - 1;
		int[] result = new int[2];
		while (left < arraySize) {
			if((nums[left] +nums[right]) == target) {
				result[0] = left;
				result[1] = right;
				return result;
			} else {
				while(right==left) {
					right --;
				}
			}
		}
		return result;

	}
	
	
	public static void main(String[] args) {
		int[] array = { 0, 14, 0, 4, 7, 8, 3, 5, 7 };
		int[] array2 = {12, 14, 17, 15, 19, 20, -11};
		//printPairs(array, 11);
		
		System.out.println("PairWithSum.main():" + printPairsUsingTwoPointers(array2, 9));
	}

}
