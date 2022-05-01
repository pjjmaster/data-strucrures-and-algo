package com.practice.google;

/*
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 
*/

public class Candy {

      public int candy(int[] ratings) {

        int[] leftToRight = new int[ratings.length];
        int[] rightToLeft = new int[ratings.length];
        Arrays.fill(leftToRight, 1);
        Arrays.fill(rightToLeft, 1);

        for(int i = 1; i < ratings.length; i++) {
           if(ratings[i] > ratings[i-1]) {
               leftToRight[i] = leftToRight[i-1] + 1;
           }    
        }
        
        for(int j = ratings.length -2; j >= 0; j--) {
            if(ratings[j] > ratings[j+1]) {
                rightToLeft[j] = rightToLeft[j+1] + 1;
            }
        }
       
        
        int sum = 0;
        for(int i=0; i < ratings.length; i++) {
            sum += Math.max(leftToRight[i], rightToLeft[i]); 
        }
        return sum;
    }

}
