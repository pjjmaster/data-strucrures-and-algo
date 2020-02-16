package com.practice.array;
import java.util.HashMap;
import java.util.Map;

public enum EmpCode {

    ASSOCIATE(10001),
    SENIOR_ASSOCIATE(10002),
    MANAGER(10003),
    SENIOR_MANAGER(10001);

   private int code;  
   private static Map internalMap = new HashMap<>();

   EmpCode(int code){
        this.code = code;
   }

    static{
        for(EmpCode empCode: EmpCode.values()){
            internalMap.put(empCode.code, empCode);
        }
    }

   // also implement this method properly
   public static EmpCode getEnum(int code)  {
       if(code !=10001 && code!=10002 && code!=10003 && code!= 10004){
           throw new IllegalArgumentException("Invalid input");
       }  
         return (EmpCode)internalMap.get(code);
         
   }

    public int getCode(){
        return code;
    }
    
    
}
