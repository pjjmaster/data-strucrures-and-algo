package com.practice.google;

/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
*/

public class DecodeString {
  
    public String decodeString(String s) {
        
        if(s == null || s.length() == 0) {
            return "";
        }
        
        Stack<Character> stack = new Stack<>();
        StringBuilder builder= new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) != ']' ) {
                stack.push(s.charAt(i));
            } else {
                List<Character> decodedString = new ArrayList<>();
                // Pop untill '[' 
                while(stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }
                // Remove opening bracket
                stack.pop();
                int k = 0;
                int base = 1;
                //calculate the number of times we have to repeat the decoded string
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base = base * 10;
                }
                
                //push again on the stack the decoded string 
                while(k!=0) {
                    for(int j = decodedString.size() - 1; j >= 0 ; j--) {
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }   
            }
        }
        
        char[] result = new char[stack.size()];
        
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
  

}
