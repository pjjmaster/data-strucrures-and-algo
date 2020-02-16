package com.test.array;

import java.util.Scanner;

public class MissingNumberInArray {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int numberOfTestcases = scanner.nextInt();

		for (int i = 0; i < numberOfTestcases; i++) {
			int[] array = extractArrayFromInput(scanner);
			getMissingNumber(array, array.length);
		}
	}

	static int getMissingNumber(int a[], int n) {
		int total = (n + 1) * (n + 2) / 2;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
		}
		System.out.println("MissingNumberInArray.getMissingNumber():" + (total - sum));
		return total - sum;
	}

	static int getMissingNo(int a[], int n) {
		int i, total;
		total = (n + 1) * (n + 2) / 2;
		for (i = 0; i < n; i++)
			total -= a[i];
		System.out.println(total);
		return total;
	}

	static int getByXOR(int array[], int n) {

		int x1 = array[0];
		int x2 = 1;

		for (int i = 1; i < n; i++) {
			x1 = x1 ^ array[i];
		}

		for (int i = 2; i <= n + 1; i++) {
			x2 = x2 ^ array[i];
		}

		int result = x1 ^ x2;
		System.out.println(result);
		return result;
	}

	private static int[] extractArrayFromInput(Scanner scanner) {

		int arraysize = scanner.nextInt();

		int[] array = new int[arraysize - 1];

		for (int j = 0; j < arraysize - 1; j++) {
			array[j] = scanner.nextInt();
		}

		return array;
	}
}
