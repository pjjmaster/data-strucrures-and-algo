package com.test.sorting;

public class SelectionSort {

	public static int[] sort(int[] array) {

		if (array.length == 0) {
			System.out.println("Empty array!!");
			return null;
		} else if (array.length == 1) {
			return array;
		}

		for (int i = 0; i < array.length - 1; i++) {
			int min_index = i;

			for (int j = i + 1; j < array.length; j++) {

				if (array[j] < array[min_index]) {
					min_index = j;
				}
			}

			int temp = array[min_index];
			array[min_index] = array[i];
			array[i] = temp;

		}
		return array;

	}

	public static void printArray(int[] array) {
		System.out.println("SelectionSort.printArray()");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = { 64, 25, 12, 22, 11 };
		printArray(sort(arr));
	}

}
