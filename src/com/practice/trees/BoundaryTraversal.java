package com.practice.trees;

public class BoundaryTraversal {

	public void boundaryTraversal(TreeNode root) {

		
		if (root == null) {
			return;
		}

		System.out.println(root.val);

		traverseLeftSide(root.left);

		printLeaves(root.left);

		printLeaves(root.right);

		traverseRightSide(root.right);

	}

	private void traverseLeftSide(TreeNode root) {

		if (root == null) {
			return;
		}

		if (root.left != null) {
			System.out.println(root.val);
			traverseLeftSide(root.left);
		} else if (root.right != null) {
			System.out.println(root.val);
			traverseLeftSide(root.right);
		}
	}

	private boolean isLeafNode(TreeNode root) {
		return (root.left == null && root.right == null);
	}

	public void printLeaves(TreeNode root) {

		if (root == null) {
			return;
		}
		printLeaves(root.left);

		if (isLeafNode(root)) {
			System.out.println(root.val);
		}

		printLeaves(root.right);
	}

	private void traverseRightSide(TreeNode root) {

		if (root == null) {
			return;
		}

		if (root.right != null) {
			traverseRightSide(root.right);
			System.out.println(root.val);
		} else if (root.left != null) {
			traverseRightSide(root.left);
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
		root.left.left.right = new TreeNode(8);
		root.left.left.right.right = new TreeNode(9);
		root.left.left.right.right.right = new TreeNode(10);

		traverse.boundaryTraversal(root);

	}

}
