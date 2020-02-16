package com.practice.array;

public class PivotedBinarySearch {

	public static int pivotedBinarySearch(int[] pivotedArray, int x) {

		int pivot = findPivot(pivotedArray, 0, pivotedArray.length - 1);
		System.out.println("Pivot:" + pivot);

		if (x == pivotedArray[pivot]) {
			return pivot;
		}

		if (pivot == -1) {
			binarySearch(pivotedArray, 0, pivotedArray.length - 1, x);
		} else if (pivotedArray[0] <= x) {
			binarySearch(pivotedArray, 0, pivot - 1, x);
		} else {
			return binarySearch(pivotedArray, pivot + 1, pivotedArray.length - 1, x);
		}

		return -1;
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
		// int arr[] = { 10, 40, 2, 3, 4 };
		// System.out.println(pivotedBinarySearch(arr, 3));
		//int arr[] = { 9, 10, 1, 2, 3, 4, 5, 6, 7, 8 };
		//System.out.println(pivotedBinarySearch(arr, 10));
		int arr[] = { 4, 5, 6, 7, 8, 1, 2, 3 };
		System.out.println(pivotedBinarySearch(arr, 2));
	}

	public static int binarySearch(int[] sortedArray, int l, int r, int x) {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (x == sortedArray[mid]) {
				return mid;
			} else if (x > sortedArray[mid]) {
				return binarySearch(sortedArray, mid, r, x);
			} else {
				return binarySearch(sortedArray, l, mid, x);
			}
		}
		return -1;
	}

}
