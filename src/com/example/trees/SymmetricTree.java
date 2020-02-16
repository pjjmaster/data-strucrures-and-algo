package com.example.trees;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

	public boolean isSymmetricRecursive(TreeNode root) {

		return isMirror(root, root);

	}

	private boolean isMirror(TreeNode node1, TreeNode node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 != null && node2 != null && node1.val == node2.val) {
			return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
		}

		return false;
	}

	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return false;
		}
		List<Integer> list = new ArrayList<>();

		inorderTraversal(root, list);

		System.out.println("SymmetricTree.isSymmetric():" + list);

		Integer[] array = new Integer[list.size()];
		array = list.toArray(array);
		int i = 0;
		int j = array.length - 1;
		while (i != j) {
			if (array[j] != array[i]) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	private void inorderTraversal(TreeNode root, List<Integer> list) {

		if (root == null) {
			return;
		}

		inorderTraversal(root.left, list);
		list.add(root.val);
		inorderTraversal(root.right, list);
	}

	public static void main(String[] args) {

	}

}
