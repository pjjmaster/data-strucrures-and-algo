import java.util.ArrayList;
import java.util.List;

public class PathSum {


  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public List<List<Integer>> getSumPaths(TreeNode root, int target) {
    List<Integer> currentPath = new ArrayList<>();
    List<List<Integer>> paths = new ArrayList<>();
    dfs(root, paths, currentPath, target);
    return paths;
  }

  private void dfs(TreeNode root, List<List<Integer>> paths, List<Integer> currentPath,
      int remainingSum) {
    if (root == null) {
      return;
    }
    currentPath.add(root.val);
    if (root.left == null && root.right == null && root.val == remainingSum) {
      paths.add(new ArrayList<>(currentPath));
    } else {
      dfs(root.left, paths, currentPath, remainingSum - root.val);
      dfs(root.right, paths, currentPath, remainingSum - root.val);
    }
    currentPath.remove(currentPath.size() - 1);
  }


  public static void main(String[] args) {
    // Sample tree:
    //       5
    //      / \
    //     4   8
    //    /   / \
    //   11  13  4
    //  /  \      \
    // 7    2      1

    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(11);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(1);

    int targetSum = 22;
    List<List<Integer>> paths = new PathSum().getSumPaths(root, targetSum);

    System.out.println("Root-to-leaf paths with target sum " + targetSum + ":");
    for (List<Integer> path : paths) {
      System.out.println(path);
    }
  }
}
