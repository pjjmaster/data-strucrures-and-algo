package com.practice.puzzles;

public class ChocWrapperPuzzle {

	public static int getNumberOfChocs(int numberOfChocs, int numberOFWraps) {

		if (numberOFWraps > numberOfChocs) {
			return 0;
		}

		int chocs = numberOfChocs / numberOFWraps;
		return chocs + getNumberOfChocs(chocs + (numberOfChocs % numberOFWraps), numberOFWraps);
	}

	public static int maxChocsToEat(int money, int priceOfChoc, int priceOfWrap) {

		int chocs = money / priceOfChoc;

		return chocs + getNumberOfChocs(chocs, priceOfWrap);
	}

	public static void main(String[] args) {

		System.out.println("ChocWrapperPuzzle.main(): " + maxChocsToEat(15, 1, 3));

	}

}
