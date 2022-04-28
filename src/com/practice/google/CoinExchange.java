package com.practice.google;
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

*/


public class CoinExchange {
  
  public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount +1);
        
        dp[0] = 0;
        
        for(int i = 0; i <= amount; i++) {
            
            for(int j = 0; j < coins.length; j++) {
                // If amount is greater than coin value then calculate
                if(coins[j] <= i) {
                    // 1 + dp[i - coins[j]] 
                    // 1 means we are considering the current coin
                    // That is why we subctract current coin value 
                    dp[i] = Math.min(dp[i] , 1 + dp[i - coins[j]]);
                }
                
            }
            
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
        
    }  
  
}
