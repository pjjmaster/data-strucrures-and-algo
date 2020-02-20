package com.practice.array;

import java.util.Arrays;

public class PrintTripletsWithgivenSum {

	public static void printTriplets(int[] array, int sum) {

		if (array.length < 3) {
			System.out.println("array size is less than 3");
			return;
		}

		Arrays.sort(array);

		for (int i = 0; i < array.length - 2; i++) {

			int left = i + 1;
			int right = array.length - 1;

			while (left < right) {

				if (array[i] + array[left] + array[right] == sum) {
					System.out.println(array[i] + " " + array[left] + " " + array[right]);
					left=right;
				} else if (array[i] + array[left] + array[right] < sum) {
					left++;
				} else {
					right--;
				}

			}

		}

	}

	public static void main(String[] args) {

		int A[] = { 1, 4, 45, 6, 10, 8, 12 };

		printTriplets(A, 22);

	}

}
