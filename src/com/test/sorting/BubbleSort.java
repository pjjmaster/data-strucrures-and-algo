package com.test.sorting;

public class BubbleSort {

	public static int[] sort(int[] array) {

		if (array.length == 0) {
			System.out.println("Empty array!!");
			return null;
		} else if (array.length == 1) {
			return array;
		}

		int n = array.length;

		for (int i = 0; i < n - 1; i++) {

			for (int j = 0; j < n - i - 1; j++) {

				if (array[j] > array[j + 1]) {

					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;

				}
			}

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
