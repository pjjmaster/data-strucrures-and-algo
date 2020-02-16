package com.test.sorting;

public class MergeSort {

	private void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}

	private void merge(int[] array, int left, int mid, int right) {

		// create two arrays
		int sizeOfLeftArray = mid - left + 1;
		int sizeOfRightArray = right - mid;

		int[] leftArray = new int[sizeOfLeftArray];
		int[] rightArray = new int[sizeOfRightArray];

		// populate two arrays
		for (int i = 0; i < sizeOfLeftArray; ++i) {
			leftArray[i] = array[left + i];
		}
		for (int i = 0; i < sizeOfRightArray; ++i) {
			rightArray[i] = array[i + mid + 1];
		}

		int i = 0, j = 0;
		int k = left;

		while (i < sizeOfLeftArray && j < sizeOfRightArray) {

			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < sizeOfLeftArray) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < sizeOfRightArray) {
			array[k] = rightArray[j];
			j++;
			k++;
		}

	}

	private void printArray(int[] array) {
		System.out.println("SelectionSort.printArray()");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = { 64, 25, 12, 22, 11 };
		MergeSort sort = new MergeSort();
		sort.mergeSort(arr, 0, arr.length);
		sort.printArray(arr);
	}

}
