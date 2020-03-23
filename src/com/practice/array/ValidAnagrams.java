package com.practice.array;

public class ValidAnagrams {

	/*
	 * Given two strings s and t , write a function to determine if t is an anagram
	 * of s. Example 1: Input: s = "anagram", t = "nagaram" Output: true
	 * 
	 */

	public static boolean isAnagram(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		int[] table = new int[26];

		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < t.length(); i++) {

			table[t.charAt(i) - 'a']--;
			if (table[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		String s1 = "anagram";
		String t1 = "nagaram";
		String s2 = "rat";
		String t2 = "car";

		System.out.println("ValidAnagrams.main():" + isAnagram(s1, t1));
		System.out.println("ValidAnagrams.main():" + isAnagram(s2, t2));

	}

}
