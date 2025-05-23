package com.practice.grind75;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */

public class LongestPrefix {

    public static String longestPrefix(String[] input) {
        // Start with first string as prefix
        String prefix = input[0];
        for (int i = 1; i < input.length; i++) {
           // Check if the next string in the array has the prefix string present at the start
           while (input[i].indexOf(prefix) != 0) {
               // If prefix is not present, shorten the string from end until we find a match
               prefix = prefix.substring(0, prefix.length()-1);
               if(prefix.isEmpty()) {
                   return "";
               }
           }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] test = {"flower", "flow", "flight"};
        String prefix = longestPrefix(test);
        System.out.println("Longest Common Prefix: " + prefix);
    }
}
