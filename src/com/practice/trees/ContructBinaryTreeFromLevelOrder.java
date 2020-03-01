package com.practice.trees;

public class ContructBinaryTreeFromLevelOrder {

	public static TreeNode contructTree(int[] array) {

		TreeNode root = new TreeNode(array[0]);

		for (int i = 0; i < array.length; i++) {
			int leftNode = (2 * i) + 1;
			int rightNode = (2 * i) + 2;
			if (leftNode < array.length) {
				root.left = new TreeNode(array[leftNode]);
			}
			if (rightNode < array.length) {
				root.right = new TreeNode(array[rightNode]);
			}
		}
		return root;
	}

	public static TreeNode recursiveint(int[] array, TreeNode root, int i) {

		if (i < array.length) {
			TreeNode temp = new TreeNode(array[i]);

			root = temp;

			root.left = recursiveint(array, root.left, 2 * i + 1);

			root.right = recursiveint(array, root.right, 2 * i + 2);

		}

		return root;
	}

	public static void main(String[] args) {

	}

}
