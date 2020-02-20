package com.practice.array;

public class MaxSumWithNoAdjacent {

	public static void printMaxSum(int[] array) {

		if (array == null || array.length == 0) {
			return;
		}

		int evensum = 0;
		int oddsum = 0;
		for (int i = 0; i < array.length; i++) {

			if (i % 2 == 0) {
				evensum += array[i];
			} else {
				oddsum += array[i];
			}

		}
		System.out.println("MaxSumWithNoAdjacent:" + Math.max(evensum, oddsum));

	}

	public static void findByDP(int[] array) {

		int inclSum = array[0];
		int exclSum = 0;
		int excl_new = 0;

		for (int i = 1; i < array.length; i++) {

			excl_new = Math.max(inclSum, exclSum);

			inclSum = exclSum + array[i];

			exclSum = excl_new;

		}

		System.out.println(Math.max(inclSum, exclSum));

	}

	public static void main(String[] args) {
		int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };

		int arr1[] = new int[] { 1, 2, 3 };

		int arr2[] = new int[] { 1, 20, 3 };

		findByDP(arr);
		findByDP(arr1);
		findByDP(arr2);

	}

}
