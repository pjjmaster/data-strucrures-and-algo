public class MaxDepthOfBinaryTree {

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = maxDepth(root.left);
    int right = maxDepth(root.right);
    return 1 + Math.max(left, right);
  }

  public static void main(String[] args) {
    //[3,9,20,null,null,15,7]
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);

    root.left.left = new TreeNode(15);
    root.left.right = new TreeNode(7);
    System.out.println(new MaxDepthOfBinaryTree().maxDepth(root));
  }

}
