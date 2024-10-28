import java.util.Arrays;

/*
Write a function to check if a person can attend all the meetings scheduled without any time conflicts. Given an array intervals, where each element [s1, e1] represents a meeting starting at time s1 and ending at time e1, determine if there are any overlapping meetings. If there is no overlap between any meetings, return true; otherwise, return false.

Note that meetings ending and starting at the same time, such as (0,5) and (5,10), do not conflict.

EXAMPLES
Input:

intervals = [(1,5),(3,9),(6,8)]
Output:

false
Explanation: The meetings (1,5) and (3,9) overlap.

Input:

intervals = [(10,12),(6,9),(13,15)]
Output:

true
Explanation: There are no overlapping meetings, so the person can attend all.

 */
public class OverlappingIntervals {

  public boolean canAttendMeetings(int[][] intervals) {
    // Sort the intervals
    Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < intervals[i-1][1]) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    int[][] intervals = {{1, 5}, {3, 9}, {6, 8}};
    System.out.println(new OverlappingIntervals().canAttendMeetings(intervals));
    int[][] intervals1 = {{10, 12}, {6, 9}, {13, 15}};
    System.out.println(new OverlappingIntervals().canAttendMeetings(intervals1));

  }
}
