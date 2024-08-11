import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
There are a total of N tasks, labeled from 0 to N-1. 
Some tasks may have prerequisites, for example to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]. 
Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.
Examples:
Input: N = 4, P = 3, prerequisites = {{1,0},{2,1},{3,2}}
Output: Yes
Input: N = 2, P = 2, prerequisites = {{1,0},{0,1}}
Output: No
**/

public class TopologicalSort {

  public boolean canFinish(int numberOfCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] inDegree = new int[numberOfCourses];

    // First populate the map with graph edges from u -> v
    for (int[] prerequisite : prerequisites) {
      int u = prerequisite[1];
      int v = prerequisite[0];
      // create a dependency mapping for each prerequisite
      //i.e {1,0} --> O depends on 1 to get completed
      graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
      // Increment the dependent courses of the course
      inDegree[v]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    // Add all courses who do not have any dependent courses
    for (int i : inDegree) {
      if (i == 0) {
        queue.offer(i);
      }
    }

    int numberCourseCompleted = 0;
    while (!queue.isEmpty()) {
      int currentCourse = queue.poll();
      numberCourseCompleted++;
      //Loop through all dependent course and decrement the inDegree

      if (graph.containsKey(currentCourse)) {
        for (int course : graph.get(currentCourse)) {
          inDegree[course]--;
          if (inDegree[course] == 0) {
            queue.offer(course);
          }
        }
      }
    }

    boolean allCoursesCompleted = numberCourseCompleted == numberOfCourses;
    return allCoursesCompleted;
  }

  public static void main(String[] args) {
    TopologicalSort topologicalSort = new TopologicalSort();
    int numCourses1 = 4;
    int[][] prerequisites1 = {{1, 0}, {2, 1}, {3, 2}};
    System.out.println(topologicalSort.canFinish(numCourses1, prerequisites1)); // Output: true

    int numCourses2 = 2;
    int[][] prerequisites2 = {{1, 0}, {0, 1}};
    System.out.println(topologicalSort.canFinish(numCourses2, prerequisites2)); // Output: false
  }
}
