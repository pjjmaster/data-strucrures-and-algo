import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

  static class Point implements Comparable<Point> {

    int x;
    int y;
    int dist;

    public Point(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }

    @Override
    public int compareTo(Point other) {
      return Integer.compare(dist, other.dist);
    }

  }

  public static void main(String[] args) {
    int[][] grid = {
        {1, 0, 0, 1},
        {1, 1, 0, 0},
        {0, 1, 1, 1},
        {1, 0, 1, 1}
    };
    int startRow = 0, startCol = 0;
    int endRow = 3, endCol = 3;

    int result = shortestPath(grid, startRow, startCol, endRow, endCol);
    System.out.println("Shortest path for unweighted: "
        + result); // Output: Shortest path: 5    System.out.println("Shortest path length: " + result); // Output: 6

    // Wighted
    int[][] gridW = {
        {1, 2, 0, 3},
        {4, 1, 2, 0},
        {3, 4, 1, 2},
        {1, 2, 3, 1}
    };
    int startRowW = 0, startColW = 0;
    int endRowW = 3, endColW = 3;

    int resultW = shortestPathWeighted(gridW, startRowW, startColW, endRowW, endColW);
    System.out.println("Shortest path with weights: " + resultW); // Output: Shortest path: 7
  }

  public static int shortestPath(int[][] grid, int startRow, int startCol, int endRow, int endCol) {
    // All four directions can be viewed as
    int[] rows = {-1, 1, 0, 0};
    int[] cols = {0, 0, -1, 1};
    // By combining rows and columns we can get a direction
    // Like rows[0] columns[0] --> matrix[-1][0] --> UP direction
    // Like rows[1] columns[1] --> matrix[1][0]  --> DOWN direction
    // Like rows[2] columns[2] --> matrix[0][-1] --> LEFT direction
    // Like rows[3] columns[3] --> matrix[0][1]  --> RIGHT direction

    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(startRow, startCol, 0));

    //Maintain a visited matrix to mark visited nodes
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    //mark source as visited
    visited[startRow][startCol] = true;

    while (!queue.isEmpty()) {
      Point current = queue.poll();

      //if it's the destination, then return the response
      if (current.x == endRow && current.y == endCol) {
        return current.dist;
      }

      //Explore all directions of node and check if
      for (int i = 0; i < 4; i++) {
        int newRow = current.x + rows[i];
        int newColumn = current.y + cols[i];
        // check if the node
        if (isValidPoint(m, n, newRow, newColumn)
            && grid[newRow][newColumn] == 1 && !visited[newRow][newColumn]) {
          Point visitingPoint = new Point(newRow, newColumn, current.dist + 1);
          queue.add(visitingPoint);
          visited[newRow][newColumn] = true;
          System.out.println(" -> [" + newRow + "][" + newColumn + "]");
        }
      }
    }

    return -1;
  }


  public static int shortestPathWeighted(int[][] grid, int startRow, int startCol, int endRow,
      int endCol) {

    int m = grid.length;
    int n = grid[0].length;

    // Define the directions UP, DOWN, LEFT and RIGHT
    int[] rows = {-1, 1, 0, 0};
    int[] cols = {0, 0, -1, 1};

    // Define an array which will keep the maxDistance
    int[][] distance = new int[m][n];
    for (int[] arr : distance) {
      Arrays.fill(arr, Integer.MAX_VALUE);
    }

    // Define a priority queue which will store the shortest distance neighbour
    PriorityQueue<Point> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(new Point(startRow, startCol, 0));

    while (!priorityQueue.isEmpty()) {
      Point current = priorityQueue.poll();
      if (current.x == endRow && current.y == endCol) {
        return current.dist;
      }

      // Check in all directions
      for (int i = 0; i < 4; i++) {
        int newRow = current.x + rows[i];
        int newCol = current.y + cols[i];
        if (isValidPoint(m, n, newRow, newCol)) {
          int newDist = current.dist + grid[newRow][newCol];
          // Check if the new distance is less than existing distance in array
          if (newDist < distance[newRow][newCol]) {
            priorityQueue.add(new Point(newRow, newCol, newDist));
            distance[newRow][newCol] = newDist;
          }
        }
      }
    }
    return -1;
  }

  private static boolean isValidPoint(int m, int n, int newRow, int newColumn) {
    return newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n;
  }
}
