package com.example.trees;

public class IsBST {

	public static boolean isValidBST(TreeNode root) {
		return isBSTHelper(root, null, null);
	}

	private static boolean isBSTHelper(TreeNode root, Integer lower, Integer upper) {

		if (root == null) {
			return true;
		}

		int value = root.val;

		if (lower != null && value <= lower) {
			return false;
		}
		
		if (upper != null && value >= upper) {
			return false;
		}

		if (!isBSTHelper(root.left, lower, value)) {
			return false;
		}

		if (!isBSTHelper(root.right, value, upper)) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(7);

		System.out.println("IsBST.main():" + isValidBST(root));

	}

}
