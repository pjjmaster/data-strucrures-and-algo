package com.practice.google;

/**
Given a string s, find the length of the longest substring without repeating characters.
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

**/
public class class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int right = 0; right < s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)));
            }
            maxLength = Math.max(maxLength, right - left + 1);
            map.put(s.charAt(right), right + 1);
        }
        return maxLength;
    }
}
