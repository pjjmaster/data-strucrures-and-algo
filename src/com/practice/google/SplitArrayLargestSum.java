package com.practice.google;

/*
Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

 

Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], m = 2
Output: 9
Example 3:

Input: nums = [1,4,4], m = 3
Output: 4

*/
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int maxElement = Integer.MIN_VALUE;
        for(int num: nums) {
            sum += num;
            maxElement = Math.max(maxElement, num);
        }
        int result = 0;
        
        // Let's apply binary search to find the result
        int left = maxElement;
        int right = sum;
        while(left <= right) {
            int maxAllowedSum = left + (right - left)/2;
            //Check how many sub arrays will be required for this sum
            int minimumSubArraysRequired = minimumSubArraysRequired(nums, maxAllowedSum);
            if(minimumSubArraysRequired <= m) {
                //move to the left
                right = maxAllowedSum - 1;
                result = maxAllowedSum;
            } else {
                left =  maxAllowedSum + 1;
            }
        }
        
        return result;
    }
    
    public int minimumSubArraysRequired(int[] nums, int maxSum) {
        int splits = 0;
        int currentSum = 0;
        for(int num : nums) {
            if(currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                splits++;
                currentSum = num;
            }
        }
        // return number of subarrays i.e. numberOfSplits + 1
        int numberOfSubArrays = splits + 1;
        return numberOfSubArrays;
    }
  
}
