package com.test.array;

public class CountFrequenciesInArray {

	private void findCounts(int[] arr, int length) {
		int i = 0;

		while (i < length) {
			if (arr[i] < 0) {
				i++;
				continue;
			}

			int elementIndex = arr[i] - 1;

			if (arr[elementIndex] > 0) {
				arr[i] = arr[elementIndex];
				arr[elementIndex] = -1;
			} else {
				// repeated number
				arr[elementIndex]--;
				arr[i] = 0;
				i++;
			}

		}
		System.out.println("Below are counts of all elements");
		for (int j = 0; j < length; j++)
			System.out.println(j + 1 + "->" + Math.abs(arr[j]));
	}

	public static void main(String[] args) {
		CountFrequenciesInArray count = new CountFrequenciesInArray();
		int arr[] = { 2, 3, 3, 2, 5 };
		count.findCounts(arr, arr.length);
	}

}
