package com.practice.array;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class StringPermutations {

	public void permute(char input[]) {
		Map<Character, Integer> countsMap = new TreeMap<>();

		for (char c : input) {
			countsMap.compute(c, (key, value) -> {
				if (value == null) {
					return 1;
				} else {
					return value + 1;
				}
			});
		}

		int counts[] = new int[countsMap.size()];
		char[] str = new char[countsMap.size()];
		int index = 0;

		for (Entry<Character, Integer> entry : countsMap.entrySet()) {
			str[index] = entry.getKey();
			counts[index] = entry.getValue();
			index++;
		}

		char[] result = new char[input.length];

		permuteUtil(str, counts, result, 0);

	}

	private void permuteUtil(char[] str, int[] counts, char[] result, int recursionLevel) {

		if(result.length == recursionLevel) {
			printArray(result);
			return;
		}
		
		for (int i = 0; i < counts.length; i++) {
			if(counts[i] ==0) {
				continue;
			}
			result[recursionLevel] = str[i];
			counts[i]--;
			permuteUtil(str, counts, result, recursionLevel +1);
			counts[i]++;
		}
	}


	
	private void printArray(char[] result) {
		for (char c : result) {
			System.out.print(c);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		StringPermutations stringPermutations = new StringPermutations();
		char[] inputArray = { 'A', 'A', 'B', 'C' };
		stringPermutations.permute(inputArray);
	}

}
