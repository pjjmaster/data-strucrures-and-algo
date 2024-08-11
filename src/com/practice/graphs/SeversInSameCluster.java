import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
Problem:
Input:
n: Number of servers.
connections: List of pairs representing direct connections between servers.
Output:
Return true if all servers belong to the same network, otherwise false.

**/


public class SeversInSameCluster {

  public boolean ifServersAreInSameCluster(int numberOfServers, int[][] connections) {
    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    for (int[] connection : connections) {
      int u = connection[0];
      int v = connection[1];
      adjacencyList.computeIfAbsent(u, e -> new ArrayList<>()).add(v);
      adjacencyList.computeIfAbsent(v, e -> new ArrayList<>()).add(u);
    }
    Set<Integer> visited = new HashSet<>();
    dfs(0, adjacencyList, visited);
    return numberOfServers == visited.size();
  }

  private void dfs(int i, Map<Integer, List<Integer>> adjacencyList, Set<Integer> visited) {
    visited.add(i);

    if (adjacencyList.containsKey(i)) {
      for (int neighbour : adjacencyList.get(i)) {
        if (!visited.contains(neighbour)) {
          dfs(neighbour, adjacencyList, visited);
        }
      }
    }
  }

  public boolean areServersConnected(int totalNumberOfServers, int[][] connections, int server1,
      int server2) {

    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int[] connection : connections) {
      int u = connection[0];
      int v = connection[1];
      graph.computeIfAbsent(u, e -> new ArrayList<>()).add(v);
      graph.computeIfAbsent(v, e -> new ArrayList<>()).add(u);
    }
    return findConnection(graph, server1, server2);
  }

  private boolean findConnection(Map<Integer, List<Integer>> graph, int source, int target) {
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(source);
    visited.add(source);

    while (!queue.isEmpty()) {
      int server = queue.poll();
      visited.add(server);
      if (server == target) {
        return true;
      }
      if (graph.containsKey(server)) {
        for (int neighbour : graph.get(server)) {
          if (!visited.contains(neighbour)) {
            visited.add(neighbour);
            queue.offer(neighbour);
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    SeversInSameCluster seversInSameCluster = new SeversInSameCluster();
    int[][] connections = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
    System.out
        .println(seversInSameCluster.ifServersAreInSameCluster(5, connections)); // Output: true

    int[][] connections2 = {{0, 1}, {2, 3}};
    System.out
        .println(seversInSameCluster.ifServersAreInSameCluster(4, connections2)); // Output: false

    int[][] connections3 = {{0, 1}, {1, 2}, {3, 4}};
    System.out
        .println(seversInSameCluster.areServersConnected(5, connections3, 0, 2)); // Output: true
    System.out
        .println(seversInSameCluster.areServersConnected(5, connections3, 0, 4)); // Output: false
  }
  
}
