import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

  public static void main(String[] args) {
    SeversInSameCluster seversInSameCluster = new SeversInSameCluster();
    int[][] connections = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
    System.out
        .println(seversInSameCluster.ifServersAreInSameCluster(5, connections)); // Output: true

    int[][] connections2 = {{0, 1}, {2, 3}};
    System.out
        .println(seversInSameCluster.ifServersAreInSameCluster(4, connections2)); // Output: false
  }
}
