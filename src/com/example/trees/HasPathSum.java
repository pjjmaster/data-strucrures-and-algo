package com.example.trees;

public class HasPathSum {

	public boolean hasPathSum(TreeNode root, int sum) {

		if (root == null) {
			return sum == 0;
		}

		boolean response = false;
		int remainder = sum - root.val;

		if (remainder == 0 && root.left == null && root.right == null) {
			return true;
		}
		
		if(root.left!=null) {
			response = response || hasPathSum(root.left, remainder);
		}

		if(root.right!=null) {
			response = response || hasPathSum(root.right, remainder);
		}
		
		return response;
	}


}
