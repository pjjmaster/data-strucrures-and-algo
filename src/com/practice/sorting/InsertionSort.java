package com.practice.sorting;

public class InsertionSort {

	public int[] sort(int[] array) {

		int size = array.length;

		for (int i = 1; i < size; i++) {

			int key = array[i];
			int j = i - 1;

			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}

			array[j+1] = key;
		}

		return array;
	}

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6 };

		InsertionSort ob = new InsertionSort();
		int[] result = ob.sort(arr);
		System.out.println("InsertionSort.main():" + result);

	}

}
