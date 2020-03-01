package com.practice.array;

public class SubArraysWithSumLessThanK {

	public static int getNumberOFSubArrays(int[] array, int k) {

		if (array.length <= 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		int sum = array[left];
		int result = 0;

		while (left < array.length && right < array.length) {

			if (sum < k) {
				right++;

				if (right >= left) {
					result = result + (right - left);
				}

				if (right < array.length) {
					sum += array[right];
				}

			} else if (sum > k) {
				sum = sum - array[left];
				left++;
			}

		}

		return result;
	}

	public static void main(String[] args) {
		// int array[] = { 1, 11, 2, 3, 15 };
		int array[] = { 2, 5, 6 };
		int k = 10;
		System.out.println("SubArraysWithSumLessThanK.main(): " + getNumberOFSubArrays(array, k));

	}

}
