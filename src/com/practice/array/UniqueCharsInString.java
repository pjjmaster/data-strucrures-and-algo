package com.practice.array;

public class UniqueCharsInString {

	public static boolean checkIfStringHasUniqueChars(String str) {

		boolean[] charset = new boolean[256];

		for (int i = 0; i < str.length(); i++) {

			char charValue = str.charAt(i);

			int asciiValue = (int) charValue;

			if (charset[asciiValue])
				return false;

			charset[asciiValue] = true;
		}

		return true;
	}

	public static void main(String[] args) {
		String str = "abcde";

		System.out.println("UniqueCharsInString.main()" + checkIfStringHasUniqueChars(str));
	}

}
