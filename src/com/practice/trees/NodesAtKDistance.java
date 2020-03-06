package com.practice.trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NodesAtKDistance {

	public List<Integer> distanceK(TreeNode root, TreeNode startNode, int distance) {

		if (root == null) {
			return null;
		}

		Map<TreeNode, TreeNode> parentMap = new HashMap<>();

		populateMap(root, null, parentMap);

		Queue<TreeNode> queue = new LinkedList<>();

		Set<TreeNode> seen = new HashSet<>();

		queue.add(startNode);

		seen.add(startNode);

		int currentLayer = 0;

		while (!queue.isEmpty()) {

			if (currentLayer == distance) {
				return getQueueContents(queue);
			}

			int layerSize = queue.size();

			for (int i = 0; i < layerSize; i++) {

				TreeNode node = queue.poll();

				// Add left
				if (node.left != null && !seen.contains(node.left)) {
					seen.add(node.left);
					queue.add(node.left);
				}

				// Add Right child
				if (node.right != null && !seen.contains(node.right)) {
					seen.add(node.right);
					queue.add(node.right);
				}

				// Add parent node
				TreeNode parent = parentMap.get(node);
				if (parent != null && !seen.contains(parent)) {
					seen.add(parent);
					queue.add(parent);
				}

			}
			currentLayer++;

		}

		return null;
	}

	private List<Integer> getQueueContents(Queue<TreeNode> queue) {
		return queue.stream().flatMap(node -> Stream.of(node.val)).collect(Collectors.toList());
	}

	private void populateMap(TreeNode root, TreeNode parentNode, Map<TreeNode, TreeNode> parentMap) {

		if (root == null) {
			return;
		}

		parentMap.put(root, parentNode);

		populateMap(root.left, root, parentMap);

		populateMap(root.right, root, parentMap);

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);

		NodesAtKDistance node = new NodesAtKDistance();
		List<Integer> list = node.distanceK(root, root.left , 3);
		list.forEach(value -> System.out.println(value));

	}

}
