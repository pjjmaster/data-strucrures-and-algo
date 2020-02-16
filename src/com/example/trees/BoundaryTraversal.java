package com.example.trees;

public class BoundaryTraversal {

	public void boundaryTraversal(TreeNode root) {

		/*
		 * 1. Traverse left side tree 2. Traverse leaf nodes 3. Traverse right side of
		 * tree
		 */

		traverseLeftSide(root);

		printLeaves(root);

		traverseRightSide(root);

	}

	private void traverseLeftSide(TreeNode root) {

		if (root == null) {
			return;
		}

		while (root.left != null && !isLeafNode(root)) {
			System.out.println(root.val);
			root = root.left;
		}
	}

	private boolean isLeafNode(TreeNode root) {
		return (root.left == null && root.right == null);
	}

	public void printLeaves(TreeNode root) {

		if (root == null) {
			return;
		}

		if (isLeafNode(root)) {
			System.out.println(root.val);
		}

		printLeaves(root.left);
		printLeaves(root.right);
	}

	private void traverseRightSide(TreeNode root) {
		if (root == null) {
			return;
		}

		traverseRightSide(root.right);
		if ( !isLeafNode(root)) {
			System.out.println(root.val);
		}
	}

	public static void main(String[] args) {

		BoundaryTraversal traverse = new BoundaryTraversal();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(10);

		traverse.boundaryTraversal(root);

	}

}
