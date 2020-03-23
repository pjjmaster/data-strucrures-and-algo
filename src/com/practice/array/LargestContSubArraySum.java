package com.practice.array;

import java.util.Scanner;

public class LargestContSubArraySum {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {

			int[] array = extractArrayFromInput(scanner);

			findByKadaneAlgorithm(array);

			// findLargestContSubArray(array);

		}

	}

	private static int findByKadaneAlgorithm2(int[] array) {

		int currentMax = array[0], globalMax = array[0];

		for (int i = 1; i < array.length; i++) {

			currentMax = Math.max(array[i], array[i] + currentMax);

			if (currentMax > globalMax) {
				globalMax = currentMax;
			}

		}
		
		return globalMax;

	}

	private static void findByKadaneAlgorithm(int[] array) {

		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;

		for (int i = 0; i < array.length; i++) {

			currentSum = currentSum + array[i];

			if (currentSum > maxSum) {
				maxSum = currentSum;
			}

			if (currentSum < 0) {
				currentSum = 0;
			}
		}

		System.out.println(maxSum);

	}

	private static void findLargestContSubArray(int[] array) {

		int maxSum = array[0];
		int currentSum = 0;
		for (int i = 0; i < array.length; i++) {
			currentSum = array[i];
			if (array[i] > maxSum) {
				maxSum = array[i];
			}
			for (int j = i + 1; j < array.length; j++) {
				currentSum = currentSum + array[j];
				if (currentSum > maxSum) {
					maxSum = currentSum;
				}
			}
		}

		System.out.println(maxSum);
	}

	private static int[] extractArrayFromInput(Scanner scanner) {

		int arraysize = scanner.nextInt();

		int[] array = new int[arraysize];

		for (int j = 0; j < arraysize; j++) {
			array[j] = scanner.nextInt();
		}

		return array;
	}

}
