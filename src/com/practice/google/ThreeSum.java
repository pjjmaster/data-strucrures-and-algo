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


}
