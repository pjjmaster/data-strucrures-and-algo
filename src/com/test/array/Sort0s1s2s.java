package com.test.array;

import java.util.Scanner;

public class Sort0s1s2s {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int numberOfTestcases = scanner.nextInt();

		for (int i = 0; i < numberOfTestcases; i++) {
			int araySize = scanner.nextInt();
			int[] array = extractArrayFromInput(scanner, araySize);
			sort(array);
			System.out.println("");
		}

	}

	private static void sort(int[] array) {

		int zeroCounter = 0;
		int oneCounter = 0;
		int twoCounter = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				zeroCounter++;
			} else if(array[i] == 1) {
				oneCounter++;
			} else if(array[i] == 2) {
				twoCounter++;
			}
		}

		for(int i= 0;i<zeroCounter;i++) {
			System.out.print(0 + " ");
		}
		
		for(int i= 0;i<oneCounter;i++) {
			System.out.print(1 + " ");
		}
		
		for(int i= 0;i<twoCounter;i++) {
			System.out.print(2 + " ");
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
