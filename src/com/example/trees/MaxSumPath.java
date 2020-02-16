package com.example.trees;

public class MaxSumPath {

	class Result {
		int maxPathSum;
	}

	public int maxPathSum(TreeNode root) {
		Result result = new Result();
		result.maxPathSum = Integer.MIN_VALUE;
		maxPath(root, result);
		return result.maxPathSum;
	}

	private int maxPath(TreeNode root, Result result) {

		if (root == null) {
			return 0;
		}

		int left = maxPath(root.left, result);
		int right = maxPath(root.right, result);

		int maxSingle = Math.max(Math.max(left, right) + root.val, root.val);

		int maxTop = Math.max(maxSingle, left + right + root.val);

		result.maxPathSum = Math.max(maxTop, result.maxPathSum);

		return maxSingle;
	}

	public static void main(String[] args) {

	}

}
