package com.practice.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FreqOfWords {

	public static void freqOfwordsAsc(List<String> sentences, List<String> words) {

		Map<String, Integer> map = new HashMap<>();

		for (String sentence : sentences) {

			for (String word : words) {
				if (sentence.contains(word)) {
					int count = map.getOrDefault(word, 0);
					map.put(word, count + 1);
				}
			}
		}

		Set<Map.Entry<String, Integer>> entries = map.entrySet();

		// Sort by frequency and then sort by key alphabetically
		entries.stream().sorted(
				Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
				.forEach(System.out::println);

	}

	public static void main(String[] args) {

		String s1 = "Tom hates Jerry Tiger";
		String s2 = "Tom and Harry Tiger";
		String s3 = "Tom and Jerry Tiger";
		String s4 = "Harry Harry Harry Tiger";
		String s5 = "Tom Tom";
		String s6 = "Jerry Jerry";

		List<String> list = new ArrayList<String>();

		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		list.add(s6);

		List<String> words = new ArrayList<>();
		words.add("Tom");
		words.add("Jerry");
		words.add("Harry");
		words.add("Tiger");

		freqOfwordsAsc(list, words);
	}

}
