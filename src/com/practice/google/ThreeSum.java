package com.practice.google;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
*/

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<nums.length && nums[i] <=0 ; i++) {
            
            if(i == 0 || nums[i-1] != nums[i]) {
                twoSum(nums, i, result);
            }
            
        }
        return result;        
    }
    
    public void twoSum(int[] nums, int i, List<List<Integer>> result) {
        Set<Integer> set = new HashSet<>();
        
        for(int j = i + 1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];
            
            if(set.contains(complement)){
                result.add(Arrays.asList(nums[i], nums[j], complement));
            }
            
            while(j+1 < nums.length && nums[j] == nums[j+1]){
                j++;
            }
            set.add(nums[j]);
        }
        
    }

    /* Approachto get two sums using two pointers
    */
    public List<List<Integer>> threeSumTwoPointer(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length && nums[i] <= 0; i++) {
            
            if(i == 0 || nums[i - 1] != nums[i]) {
                twoSums(nums, i, result);
            }
        }
        return result;
    }
    
    private void twoSumsTwoPointers(int[] nums, int i, List<List<Integer>> result) {
        
        int start = i + 1;
        int end = nums.length -1;
        
        while(start < end) {
         
            int sum = nums[i] + nums[start] + nums[end];
            
            if(sum < 0) {
                start ++;
            } else if(sum > 0) {
                end--;
            } else {
                List<Integer> triplet = Arrays.asList(nums[i], nums[start], nums[end]);
                result.add(triplet);
                start++;
                end--;
                while(start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
            }
        }
        
    }
    
    

}
