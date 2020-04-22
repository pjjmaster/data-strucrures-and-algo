package com.practice.trees;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfTree {

	static class TreeNode {
		int data;
		int distance;

		public TreeNode(int data) {
			this.data = data;
		}

		TreeNode left;
		TreeNode right;

	}

	public static void bottomViewOfBinaryTree(TreeNode root) {

		if (null == root) {
			return;
		}

		Map<Integer, TreeNode> map = new TreeMap<>();

		Queue<TreeNode> queue = new ArrayDeque<BottomViewOfTree.TreeNode>();

		root.distance = 0;

		queue.add(root);

		while (!queue.isEmpty()) {

			TreeNode tempNode = queue.poll();
			int distance = tempNode.distance;

			map.put(tempNode.distance, tempNode);

			if (tempNode.left != null) {
				tempNode.left.distance = distance--;
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				tempNode.right.distance = distance++;
				queue.add(tempNode.right);
			}

		}

		map.entrySet().stream().forEach(e -> System.out.println(e.getValue().data));
	}

	public static void main(String[] args) {

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

		bottomViewOfBinaryTree(root);
		
	}

}
