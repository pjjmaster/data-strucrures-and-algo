package com.practice.google;

/**
Instructions

Given an input string of arbitrary length, output SMS-compliant segments with suffixes.

A SMS-compliant segment is of length 160 characters or less.
Do not generate segments if the input fits in a single message.
A segment suffix looks like "(1/5)" for the first of five segments.
The segment content and suffix must both fit in the segment.
You must complete the function/method stub to return an array of message segments.

Input Constraints

Inputs will only consist of A-Z, a-z, spaces ( ), commas (,) and periods (.)
Your implementation can expect a maximum of 9 segments per input.

Extra Credit Case

The third test case has an additional output constraint: do not split words between segments! You should be able to iterate on your existing implementation.

Words will be delimited by a single space. Do not split on any other punctuation. You do not need to account for "unbreakable" i.e extremely long words in the input.
Spaces between words should be preserved in the first segment unless that violates the SMS length constraint, in which case the space should be included in the next segment.

**/

public class SmsSplit {
  
    //Working solution
      public static List<String> segments(String message) {
        List<String> result = new ArrayList<>();
        if (message.length() < 160) {
            result.add(message);
            return result;
        }
        
        int segmentSize = 154;
        int start= 0;
        int end = start + segmentSize;
        
        while(end < message.length()) {
            
            if(message.charAt(end) != ' ') {
                
                while(end >=start && message.charAt(end) != ' ' 
                        && message.charAt(end + 1) != ' ') {
                    end--;
                }
                
            }
            
            result.add(message.substring(start, end + 1));
            start = end + 1;
            end = start + segmentSize; 
        }
         
        result.add(message.substring(start, message.length()));
        
        for(int i = 0; i< result.size(); i++) {
            result.set(i, result.get(i)+ "(" + (i+1) + "/" + result.size() + ")");
        }
        return result;
        
    }


  
  
  
    public static List<String> segments(String message) {
        List<String> segments = new ArrayList<>();
        if(message.length() < 160) {
            segments.add(message);
            return segments;
        }
        Map<Integer, String> map = new HashMap<>(); 
        
        String[] messages = message.split(" ");        
        StringBuilder builder = new StringBuilder(); 
        int msgNumber = 1;
        int count = 1;
        System.out.println("messages:" + messages.length);
        for(String msg : messages) {
            
            if( (msg.length() + builder.length() + 1) > 155 ) {
                map.put(msgNumber, builder.toString());
                builder = new StringBuilder(msg + ' ');
                msgNumber++; 
            } else {
                builder.append(msg);
                System.out.println("count:" + count);
                if(count < messages.length) {
                    builder.append(' ');
                }                
            }
            count++;
            
        }
        if(builder.length() > 0) {
            map.put(msgNumber, builder.toString());
        }
        
        System.out.println("Map:" + map);
        for(Integer key: map.keySet()) {
            segments.add(map.get(key) + "(" + key + "/" +map.size() + ")");
        }
        System.out.println("Result.segments() : " + segments);
        
    
        return segments;
    }

  
  

}
