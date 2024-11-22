public class DiameterOfBinaryTree {

  int max = 0;

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public int getDiameterOfBinaryTree(TreeNode root) {
    return dfs(root);
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = dfs(root.left);
    int right = dfs(root.right);
    max = Math.max(max, (left + right));
    return 1 + Math.max(left, right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);

    root.left.left = new TreeNode(15);
    root.left.right = new TreeNode(7);
    System.out.println(new DiameterOfBinaryTree().getDiameterOfBinaryTree(root));
  }
}
