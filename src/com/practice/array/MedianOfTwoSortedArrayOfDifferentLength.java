package com.practice.array;

public class MedianOfTwoSortedArrayOfDifferentLength {

	public static double findMedianSortedArrays(int input1[], int input2[]) {

		int x = input1.length ;
		int y = input2.length ;
		if (x > y) {
			return findMedianSortedArrays(input2, input1);
		}

		// Perform binary search on smaller array
		int start = 0;
		int end = x;

		while (start <= end) {

			int partitionX = (start + end) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX = input1[partitionX - 1];
			int minRightX = input1[partitionX];

			int maxLeftY = input2[partitionY - 1];
			int minRightY = input2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				// All parttinaed elements on left are smaller than elemnets in rightPartition
				if ((x + y) % 2 == 0) {
					return ((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2);
				} else {
					return (double) Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) {
				end = partitionX - 1;
			} else {
				start = partitionX + 1;
			}

		}

		return 0;
	}

	public static void main(String[] args) {

		int[] input1 = { 1, 3, 8, 9, 15 };
		int[] input2 = { 7, 11, 18, 19, 21, 25 };

		System.out.println("MedianOfTwoSortedArrayOfDifferentLength.main(): " + findMedianSortedArrays(input1, input2));
	}

}
