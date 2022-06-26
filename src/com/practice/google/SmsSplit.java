package com.practice.google;

public class SmsSplit {
  
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
