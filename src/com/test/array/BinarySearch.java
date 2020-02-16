package com.test.array;

public class BinarySearch {

	private static void binarySearch(int[] sortedArray, int l, int r, int x) {

		if (r >= l) {
			int mid = (l + r) / 2;

			if (x == sortedArray[mid]) {
				System.out.println("BinarySearch.binarySearch(): Index:" + mid);
			} else if (sortedArray[mid] > x) {
				binarySearch(sortedArray, l, mid, x);
			} else if (sortedArray[mid] < x) {
				binarySearch(sortedArray, mid, r, x);
			}

		}

	}

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		//binarySearch(arr, 0, arr.length - 1, 10);

		int arr1[] = { 3, 4, 5, 1, 2 };
		binarySearch(arr1, 0, arr1.length, 1);
	}
}
