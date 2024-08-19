import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
  This method should return an integer array with two elements that correctly identifies the location of the longest 
 *  uniform substring within the input string. The first element of the array should be the starting index of the longest 
 *  substring and the second element should be the length.
 *  
 *  e.g.
 *      
 *      for the input: "abbbccda" the longest uniform substring is "bbb" (which starts at index 1 and is 3 characters long).

**/
public class LargestContSubArray {

  public static int[] largestUniqueSubArray(String input) {
    if (input.length() < 0) {
      return new int[]{-1, 0};
    }
    int currentMax = 1;
    int max = 1;
    int startIndex = 0;
    int currentStartIndex = 0;
    for (int i = 1; i < input.length(); i++) {
      if (input.charAt(i) == input.charAt(i - 1)) {
        currentMax++;
      } else {
        currentStartIndex = i;
        currentMax = 1;
      }
      if (currentMax > max) {
        max = currentMax;
        startIndex = currentStartIndex;
      }
    }
    return new int[]{startIndex, max};
  }


  public static void main(String[] args) {
    String s = "abbbccddddda";
    Arrays.stream(largestUniqueSubArray(s)).forEach(System.out::println);
  }
}
