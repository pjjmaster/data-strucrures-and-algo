package com.practice.array;

public class IsPowerOf10 {

	public static boolean isPowerOf10Rec(int x) {

		if (x % 10 != 0 || x == 0) {
			return false;
		}

		if (x == 10) {
			return true;
		}

		return isPowerOf10Rec(x / 10);
	}

	public static boolean isPowerOf10(int x) {
		while(x>9 && x%10==0) {
			x = x/10;
		}
		
		return x==1;
	
	}

	public static void main(String[] args) {
		System.out.println("IsPowerOf10.main()" + isPowerOf10(10000));
	}

}
