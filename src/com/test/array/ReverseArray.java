package com.test.array;

public class ReverseArray {

	private static int[] reverseArray(int[] array, int start, int end) {
		while (start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
		
		printArray(array);
		return array;
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}

	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		reverseArray(arr, 0, arr.length - 1);
	}

}
