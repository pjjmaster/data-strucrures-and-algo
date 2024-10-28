/*
Given an array of integers nums and an integer k, find the maximum sum of any contiguous subarray of size k.

EXAMPLES
Example 1: Input:

nums = [2, 1, 5, 1, 3, 2]
k = 3
Output:

9
Explanation: The subarray with the maximum sum is [5, 1, 3] with a sum of 9.

 */
public class MaxSumOfSubArrays {

  public int getMaxSum(int[] array, int k) {
    int maxSum = 0;

    int currentSum = 0;
    int start = 0;
    int end = 0;

    while (end < array.length && start <= end) {
        currentSum += array[end];
        end++;
        if((end -start) == k){
          maxSum = Math.max(maxSum, currentSum);
          currentSum=currentSum - array[start];
          start++;
        }
    }

    return maxSum;
  }

  public static void main(String[] args) {
    int[] nums = {2, 1, 5, 1, 3, 2};
    int k = 3;
    System.out.println(new MaxSumOfSubArrays().getMaxSum(nums, k));
  }
}
