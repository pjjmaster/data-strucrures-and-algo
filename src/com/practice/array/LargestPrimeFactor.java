package com.practice.array;

public class LargestPrimeFactor {

	public long getLargestPrimeFactor(long number) {

		long i;

		long input = number;

		for (i = 2; i <= input; i++) {

			if (input % i == 0) {
				input /= i;
				i--;
			}
		}
		return i;

	}

	public static void main(String[] args) {

	}

}
