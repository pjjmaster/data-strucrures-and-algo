package com.practice.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {
	public static int getMajorityElement(int[] array) {

		int size = array.length;
		int majorityNumber = size / 2 + 1;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < size; i++) {
			if (map.containsKey(array[i])) {
				int count = map.get(array[i]);
				if (count + 1 >= majorityNumber) {
					return array[i];
				} else {
					map.put(array[i], count + 1);
				}
			} else {
				map.put(array[i], 1);
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int numberOfTestcases = scanner.nextInt();

		for (int i = 0; i < numberOfTestcases; i++) {
			int[] array = extractArrayFromInput(scanner);
			System.out.println(getMajorityElement(array));
		}

	}

	private static int[] extractArrayFromInput(Scanner scanner) {

		int arraysize = scanner.nextInt();

		int[] array = new int[arraysize];

		for (int j = 0; j < arraysize - 1; j++) {
			array[j] = scanner.nextInt();
		}

		return array;
	}
}
