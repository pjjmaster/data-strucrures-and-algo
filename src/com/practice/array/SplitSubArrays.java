package com.practice.array;

import java.util.List;

public class SplitSubArrays {

	public static int splitTheArray(List<Integer> val) {

		int[] array = val.stream().mapToInt(i -> i).toArray();

		return contiguousSubArray(array, array.length);
	}

	public static int contiguousSubArray(int[] array, int length) {

		int count = 0;

		for (int i = 0; i < length; i++) {
			int currenGcd = 0;

			for (int j = i; j < length; j++) {
				currenGcd = gcdOf(currenGcd, array[j]);

				count += (currenGcd == 1) ? 1 : 0;
			}

		}

		return count;
	}

	public static int gcdOf(int i, int j) {
		if (j == 0) {
			return i;
		}

		return gcdOf(j, i % j);

	}

	public static int splitArray(int[] array) {

		int size = array.length;

		if (size == 0) {
			return 0;
		}

		int subArray = 0;
		int index = size - 1;
		while (index >= 0) {
			
			for(int i =0;i<=index;i++) {
				if(gcdOf(array[index], array[i])>1) {
					subArray++;
					index = i-1;
					break;
				}
			}
			
		}

		return subArray;
	}
}
