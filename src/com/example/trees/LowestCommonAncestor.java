package com.example.trees;

public class LowestCommonAncestor {

	public static TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {

		if (root == null) {
			return null;
		}

		if (root.val == node1.val || root.val == node2.val) {
			return root;
		}

		TreeNode leftSearchResult = findLCA(root.left, node1, node2);
		TreeNode rightSearchResult = findLCA(root.right, node1, node2);

		if (leftSearchResult == null) {
			return rightSearchResult;
		}

		if (rightSearchResult == null) {
			return leftSearchResult;
		}

		return root;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(6);

		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(8);

		TreeNode result = findLCA(root, new TreeNode(6), new TreeNode(4));
		System.out.println("LowestCommonAncestor.main():" + result.val);
	}

}
