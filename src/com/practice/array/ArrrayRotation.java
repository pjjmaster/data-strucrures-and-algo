package com.practice.array;

import java.util.Scanner;

public class ArrrayRotation {

	public static void rotate(int array[], int rotate, int size) {
		int temp[] = new int[rotate];
		for (int i = 0; i < rotate; i++) {
			temp[i] = array[i];
		}

		for (int i = 0; i < size - rotate; i++) {
			array[i] = array[i + rotate];
		}

		for (int i = 0; i < temp.length; i++) {
			array[(size - rotate) + i] = temp[i];
		}
		System.out.println("ArrrayRotation.rotate()");
	}

	public static void leftRotate(int array[], int rotate, int size) {
		for (int i = 0; i < rotate; i++) {
			leftRotateByOne(array, size);
		}
		printArray(array);
	}

	private static void printArray(int[] array) {
		for(int i =0;i<array.length;i++) {
			System.out.print(array[i]);
		}
	}

	private static void leftRotateByOne(int array[], int size) {
		int temp = array[0];
		int i;
		for (i = 0; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		array[i] = temp;
	}


	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6 };

		leftRotate(array, 2, array.length);
		
		Scanner scanner = new Scanner(System.in);
		scanner.next();

	}

}
