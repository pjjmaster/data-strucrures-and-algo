package com.test.array;

import java.util.Scanner;

public class SubArrayWithSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numberOfTestcases = scanner.nextInt();

		for (int i = 0; i < numberOfTestcases; i++) {
			int arraySize = scanner.nextInt();
			int expectedSum = scanner.nextInt();
			int[] array = extractArrayFromInput(scanner, arraySize);
			// printSubArrayWithSum(array, expectedSum);
			printSubArrayEfficient(array, expectedSum);
		}

	}

	private static void printSubArrayWithSum(int[] array, int expectedSum) {

		int currentSum = 0;

		for (int i = 0; i < array.length; i++) {
			currentSum = array[i];
			for (int j = i + 1; j < array.length; j++) {

				if (i == j) {
					System.out.println(-1);
				}

				currentSum += array[j];

				if (currentSum > expectedSum) {
					break;
				}

				if (currentSum == expectedSum) {
					System.out.println(++i + " " + ++j);
					return;
				}

			}

		}

	}

	private static void printSubArrayEfficient(int[] array, int expectedSum) {

		int currentSum = array[0];
		int start = 0;

		for (int i = 1; i <= array.length; i++) {

			while (currentSum > expectedSum && start < i - 1) {
				currentSum -= array[start];
				start++;
			}

			if (currentSum == expectedSum) {
				System.out.println((start + 1) + " " + i);
				break;
			}
			if (i < array.length) {
				currentSum += array[i];
			} else {
				System.out.println(-1);
			}
		}

	}

	private static int[] extractArrayFromInput(Scanner scanner, int arraySize) {

		int[] array = new int[arraySize];

		for (int j = 0; j < arraySize; j++) {
			array[j] = scanner.nextInt();
		}

		return array;
	}

}
