package com.practice.array;

public class RearrangeNumbers {

	public static void reArrange(int[] array) {

		int j = array.length - 1;

		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				continue;
			}

			while (array[j] > 0 && j >= i) {
				j--;
			}

			if(i>=j) {
				return;
			}
			
			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
		}

		System.out.println("RearrangeNumbers.main()" + array);

	}

	public static void main(String[] args) {
		int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };

		reArrange(arr);
		// reArrange(arr, 0, arr.length - 1);

		System.out.println("RearrangeNumbers.main()" + arr);
	}

}
