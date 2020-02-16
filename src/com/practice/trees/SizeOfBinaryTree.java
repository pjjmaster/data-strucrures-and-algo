package com.practice.trees;

public class SizeOfBinaryTree {

	public static int sizeOfBinaryTree(TreeNode root) {

		if (root == null) {
			return 0;
		}

		return sizeOfBinaryTree(root.left) + 1 + sizeOfBinaryTree(root.right);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println("SizeOfBinaryTree.main():" + sizeOfBinaryTree(root));

	}

}
