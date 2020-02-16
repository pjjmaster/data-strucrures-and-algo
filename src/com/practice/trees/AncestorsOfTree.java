package com.practice.trees;

import java.util.Stack;

public class AncestorsOfTree {

	public static void getAncestersUsingStackImpl(TreeNode root, TreeNode node) {

		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();

		while (true) {

			while (root != null && root.val != node.val) {
				stack.push(root);
				root = root.left;
			}

			if (root != null && root.val == node.val) {
				break;
			}

			if (stack.peek().right == null) {
				root = stack.peek();
				stack.pop();

				while (!stack.isEmpty() && stack.peek().right == root) {
					root = stack.peek();
					stack.pop();
				}

			}

			root = stack.isEmpty() ? null : stack.peek().right;

		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop().val);

		}

	}

	public static boolean recursive(TreeNode root, TreeNode node) {

		if (root == null) {
			return false;
		}

		if (root.val == node.val) {
			return true;
		}

		boolean found = recursive(root.left, node);
		if (!found) {
			found = recursive(root.right, node);
		}

		if (found) {
			System.out.print(root.val + " ");
			return true;
		}
		return false;

	}

	public static void main(String[] args) {

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

		recursive(root, new TreeNode(10));

	}

}
