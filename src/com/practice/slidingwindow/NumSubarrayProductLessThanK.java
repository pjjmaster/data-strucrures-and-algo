public class NumSubarrayProductLessThanK {

  public static int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) {
      return 0;
    }
    int result = 0;
    int left = 0;
    int right = 0;
    int currentProduct = 1;

    while (right < nums.length) {
      currentProduct = currentProduct * nums[right];
      while (currentProduct >= k) {
        currentProduct = currentProduct / nums[left];
        left++;
      }
      result = result + (right - left) + 1;
      right++;
    }
    return result;

  }

  public static void main(String[] args) {
    int[] input = new int[]{10, 5, 2, 6};
    int k = 100;
    System.out.println(numSubarrayProductLessThanK(input, k));
  }

}
