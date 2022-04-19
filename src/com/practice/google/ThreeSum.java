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

    /*
    Approach 3: "No-Sort"
What if you cannot modify the input array, and you want to avoid copying it due to memory constraints?
We can adapt the hashset approach above to work for an unsorted array. We can put a combination of three values into a hashset to avoid duplicates. 
Values in a combination should be ordered (e.g. ascending). Otherwise, we can have results with the same values in the different positions.

Algorithm
The algorithm is similar to the hashset approach above. We just need to add few optimizations so that it works efficiently for repeated values:

Use another hashset dups to skip duplicates in the outer loop.
Without this optimization, the submission will time out for the test case with 3,000 zeroes. This case is handled naturally when the array is sorted.
Instead of re-populating a hashset every time in the inner loop, we can use a hashmap and populate it once. 
    Values in the hashmap will indicate whether we have encountered that element in the current iteration. When we process nums[j] in the inner loop, we set its hashmap value to i. This indicates that we can now use nums[j] as a complement for nums[i].
This is more like a trick to compensate for container overheads. The effect varies by language, e.g. for C++ it cuts the runtime in half. Without this trick the submission may time out.
 */
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> resultSet = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(visited.add(nums[i])) {
                for(int j = i + 1; j < nums.length; j++) {
                    int complement = -nums[i] - nums[j];
                    if(map.containsKey(complement) && map.get(complement) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        resultSet.add(triplet);
                    }
                    map.put(nums[j], i);
                }    
            }
        }
        return new ArrayList(resultSet);
    }
    
    
    
    

}
