package com.practice.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CountFreqOfChars {

	public static Map<Character, Integer> count(String string) {

		char[] charArray = string.toCharArray();

		Map<Character, Integer> map = new HashMap<>();

		for (char c : charArray) {
			int count = map.getOrDefault(c, 0);
			map.put(c, count + 1);
		}

		List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());

		Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

		for (Map.Entry<Character, Integer> entry : list) {
			System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
		}
		
		return map;
		
	}

	public static void main(String[] args) {

		String s = "abbbbbbccccdeeeeeeeeeeeeeee";
		count(s);
		
	}

}
