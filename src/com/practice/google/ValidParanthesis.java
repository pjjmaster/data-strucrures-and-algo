package com.practice.google;


/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
Example 1:
Input: s = "()"
Output: true
Example 2:
Input: s = "()[]{}"
Output: true
*/

public class ValidParanthesis {

  Map<Character, Character> map;
  
  public ValidParanthesis(){
    map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');
  }
  
  public boolean isValidUsingStack(String s) {
  
    Stack<Character> stack = new Stack<>();
    
    for(char c: s.toCharArray()) {
      if(stack.containsKey(c)) {
        // If closing bracket
        // Get the opening bracket for character
        char opening = map.get(c);
        
        if(opeing != stack.pop()) {
          return false;
        }
      } else {
        stack.push(c);
      }
    }
    return stack.empty();  
  }
  
  
  public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
          if(c == '(') {
            stack.push(')');
          } else if(c == '{') {
            stack.push('}');
          } else if(c == '[') {
            stack.push(']');
          } else if(stack.isEmpty() || c != stack.pop()) {
            return false;
          }
        }
        return stack.isEmpty();
        
    }
    
    
    
}


