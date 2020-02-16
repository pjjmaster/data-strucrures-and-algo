package com.practice.array;

public class Convert0To5 {

	static int convert0To5(int number) {

		if (number == 0) {
			return 5;
		} else {
			return convert0To5Rec(number);
		}

	}

	private static int convert0To5Rec(int number) {

		if(number ==0) {
			return 0;
		}
		
		int lastDigit = number % 10;

		if (lastDigit == 0) {
			lastDigit = 5;
		}

		return convert0To5Rec(number / 10) * 10 + lastDigit;

	}

	public static void main(String[] args) {
		System.out.println(convert0To5(10120)); 
	}
	
	

}
