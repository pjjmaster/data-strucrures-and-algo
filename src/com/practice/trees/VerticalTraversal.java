package com.practice.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class VerticalTraversal {

	public static void verticalTraversal(TreeNode root) {

		Map<Integer, List<Integer>> map = new TreeMap<>();
		int distance = 0;

		traverse(root, distance, map);

		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}

	}

	public static void traverse(TreeNode node, Integer distance, Map<Integer, List<Integer>> map) {

		if (node == null) {
			return;
		}

		List<Integer> list = map.get(distance);

		if (list == null) {
			list = new ArrayList<Integer>();
		}
		list.add(node.val);

		map.put(distance, list);

		traverse(node.left, distance - 1, map);

		traverse(node.right, distance + 1, map);

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
		root.left.left.right = new TreeNode(9);
		root.left.left.left.right = new TreeNode(10);

		verticalTraversal(root);

	}

}
