public class BinaryTreeTilt {

  public int tilt = 0;

  public static class TreeNode {

    private int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public int getTilt(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftWeight = getTilt(root.left);
    int rightWeight = getTilt(root.right);
    tilt += Math.abs(leftWeight - rightWeight);
    return leftWeight + rightWeight + root.val;
  }

  public int getTiltValue() {
    return this.tilt;
  }

  public static void main(String[] args) {
    //[4, 2, 7, 1, 3, 6, 9]
    //         4
    //       /   \
    //      2     7
    //     / \   / \
    //    1   3 6   9
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);

    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);

    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);

    BinaryTreeTilt binaryTreeTilt = new BinaryTreeTilt();
    binaryTreeTilt.getTilt(root);
    System.out.println(binaryTreeTilt.getTiltValue());

  }
}
