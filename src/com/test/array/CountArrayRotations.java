package com.test.array;

public class CountArrayRotations {

	public static int countRotations(int[] sortedArray) {
		int minIndex = 0;
		int minValue = sortedArray[0];
		for (int i = 0; i < sortedArray.length; i++) {
			if (minValue > sortedArray[i]) {
				minValue = sortedArray[i];
				minIndex = i;
			}
		}

		return minIndex;
	}

	public static int countRotations(int[] sortedArray, int low, int high) {

		if (low > high) {
			return 0;
		}
		if (low == high) {
			return low;
		}

		int mid = (low + high) / 2;
		if (sortedArray[mid + 1] < sortedArray[mid]) {
			return mid;
		} else if (sortedArray[mid] < sortedArray[mid - 1]) {
			return mid - 1;
		} else if (sortedArray[low] > sortedArray[mid]) {
			return countRotations(sortedArray, low, mid - 1);
		}
		return countRotations(sortedArray, mid + 1, high);
	}

	private static int findPivot(int[] pivotedArray, int l, int r) {

		if (r < l) {
			return -1;
		}
		if (r == l) {
			return l;
		}

		int mid = (l + r) / 2;

		if (mid < r && pivotedArray[mid + 1] < pivotedArray[mid]) {
			return mid;
		} else if (mid > l && pivotedArray[mid] < pivotedArray[mid - 1]) {
			return mid - 1;
		} else if (pivotedArray[l] > pivotedArray[mid]) {
			return findPivot(pivotedArray, l, mid - 1);
		}
		return findPivot(pivotedArray, mid + 1, r);

	}

	public static void main(String[] args) {
		// int arr[] = { 4, 5, 6, 7, 8, 1, 2, 3 };
		//int arr[] = {15, 18, 2, 3, 6, 12};
		// System.out.println(countRotations(arr));
		int arr[] = { 7, 8, 1, 2, 3, 4, 5, 6 };
		System.out.println(countRotations(arr, 0, arr.length - 1) +1);
	}

}
