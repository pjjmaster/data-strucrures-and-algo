package com.practice.array;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithUniqueChars {

	  public static int[] largestUniqueSubArray(String input) {
	    if (input.length() < 0) {
	      return new int[]{-1, 0};
	    }
	    int currentMax = 1;
	    int max = 1;
	    int startIndex = 0;
	    int currentStartIndex = 0;
	    for (int i = 1; i < input.length(); i++) {
	      if (input.charAt(i) == input.charAt(i - 1)) {
	        currentMax++;
	      } else {
	        currentStartIndex = i;
	        currentMax = 1;
	      }
	      if (currentMax > max) {
	        max = currentMax;
	        startIndex = currentStartIndex;
	      }
	    }
	    return new int[]{startIndex, max};
	  }
	
	
	static final int NO_OF_CHARS = 256;
	
	public static int lengthOfLongestSubstringUsingHashSet(String string) {
		int maxSize = 0;

		Set<Character> set = new HashSet<>();

		int leftPointer = 0;
		int rightPointer = 0;

		while (rightPointer < string.length()) {

			if (!set.contains(string.charAt(rightPointer))) {
				set.add(string.charAt(rightPointer));
				maxSize = Math.max(maxSize, set.size());
				rightPointer++;
			} else {
				set.remove(string.charAt(rightPointer));
				leftPointer++;
			}

		}
		return maxSize;
	}

	public static int lengthOfLongestSubstring(String str) {

		int maxLength = 1;
		int currentLength = 1;
		int previous;
		int i;
		int visited[] = new int[NO_OF_CHARS];

		for (i = 0; i < NO_OF_CHARS; i++) {
			visited[i] = -1;
		}

		visited[str.charAt(0)] = 0;

		for (i = 1; i < str.length(); i++) {
			previous = visited[str.charAt(i)];

			if (previous == -1 || i - currentLength > previous) {
				currentLength++;
			} else {
				if (currentLength > maxLength) {
					maxLength = currentLength;
				}
				currentLength = i - previous;
			}
			visited[str.charAt(i)] = i;
		}
		if (currentLength > maxLength)
			maxLength = currentLength;

		return maxLength;
	}

	public static void main(String[] args) {
		System.out
				.println("LongestSubstringWithUniqueChars.main():" + lengthOfLongestSubstringUsingHashSet("abcabcbb"));
	}
}
