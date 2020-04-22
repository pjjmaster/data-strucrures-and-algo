package com.practice.trees;

import java.util.LinkedList;
import java.util.Queue;

public class DepthOfBinaryTree {

	public static int depthOfBinaryTree(TreeNode root) {

		int depth = 0;

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);
		queue.offer(null);

		while (!queue.isEmpty()) {

			TreeNode node = queue.poll();

			if (node != null) {
				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}
			} else {
				depth++;
				if (!queue.isEmpty()) {
					queue.offer(null);
				}
			}
		}

		return depth;
	}

	public static int dfs(TreeNode root) {
		return dfsRec(root);
	}

	private static int dfsRec(TreeNode root) {

		if (root == null) {
			return Integer.MIN_VALUE;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}
		
		
		return Math.max(dfsRec(root.left), dfsRec(root.right)) + 1;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(8);
		root.left.right.right.right = new TreeNode(9);
		root.left.right.right.right.right = new TreeNode(10);

		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println("DepthOfBinaryTree.main()" + depthOfBinaryTree(root));
		System.out.println("DepthOfBinaryTree.main()" + dfs(root));

	}

}
