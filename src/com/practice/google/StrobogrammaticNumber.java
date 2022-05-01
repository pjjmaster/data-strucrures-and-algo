package com.practice.google;

/*
Given a string num which represents an integer, return true if num is a strobogrammatic number.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Example 1:

Input: num = "69"
Output: true
*/

public class Strobogrammatic {
  
      public boolean isStrobogrammatic(String num) {
        
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        StringBuilder builder = new StringBuilder();
        for(int i = num.length() - 1; i >= 0; i--) {
            char character = num.charAt(i);
            if(map.get(character) == null) return false;
            builder.append(map.get(character));
        }
        
        return num.equals(builder.toString());
    }


}

