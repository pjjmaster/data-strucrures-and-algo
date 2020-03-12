package com.practice.dp;

public class CoinExchangeWithMinCoins {

	static int n = 4;
	static int coins[] = { 9, 6, 5, 1 };

	public static int minCoinsRec(int capacity, int index) {

		if (index > n) {
			return 0;
		}

		if (coins[index] > capacity) {
			return minCoinsRec(capacity, index++);
		} else if (coins[index] < capacity) {
			
			return Math.min(1 + minCoinsRec(capacity - coins[index], index + 1), minCoinsRec(capacity, index++));

		}
		return -1;
	}

	public static int minCoins(int[] coins, int capacity, int n) {

		if (capacity == 0) {
			return 0;
		}

		return 0;
	}

	public static void main(String[] args) {

		int coins[] = { 9, 6, 5, 1 };
		int m = coins.length;
		int n = 11;

	}

}
