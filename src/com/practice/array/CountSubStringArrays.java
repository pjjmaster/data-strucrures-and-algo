package com.practice.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CountSubStringArrays {

	public static int vowelsubstringold(String s) {

		int count = 0;
		String temp = "";

		for (int i = 0; i < s.length(); i++) {
			if (isVowel(s.charAt(i))) {
				temp += s.charAt(i);
			} else {
				if (temp.length() > 0) {
					count += countSubString(temp.toCharArray());
				}
				temp = "";
			}
		}

		if (temp.length() > 0) {
			count += countSubString(temp.toCharArray());
		}

		return count;

	}

	public static int countSubString(char[] chars) {

		int start = 0;
		int count = 0;

		Map<Character, Integer> countMap = new HashMap<>();

		int length = chars.length;
		for (int i = 0; i < length; i++) {

			if (countMap.containsKey(chars[i])) {
				countMap.put(chars[i], countMap.get(chars[i]) + 1);
			} else {
				countMap.put(chars[i], 1);
			}

			/*
			 * int charCount = countMap.getOrDefault(chars[i], 0); countMap.put(chars[i],
			 * charCount + 1);
			 */
			while (countMap.containsKey('a') && countMap.containsKey('e') && countMap.containsKey('i')
					&& countMap.containsKey('o') && countMap.containsKey('u') && countMap.get('a') > 0
					&& countMap.get('e') > 0 && countMap.get('i') > 0 && countMap.get('o') > 0
					&& countMap.get('u') > 0) {

				count += length - i;
				countMap.put(chars[start], countMap.get(chars[start]) - 1);
				start++;
			}

		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	public static int vowelsubstring(String s) {

		HashSet<Character> charSet = new HashSet<>();

		int start, count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (isVowel(s.charAt(i)) == true) {
				charSet.add(s.charAt(i));
			}

			if (charSet.size() == 5) {
				count++;
			} else {
				start = i + 1;
				charSet.clear();
			}
		}
		return count;

	}
}
