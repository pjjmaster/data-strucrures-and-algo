package com.practice.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	public static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode root) {

		ArrayList<ArrayList<Integer>> resultArrays = new ArrayList<>();

		if (root == null) {
			return resultArrays;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);

		ArrayList<Integer> currentList = new ArrayList<>();

		while (!queue.isEmpty()) {

			TreeNode tmp = queue.poll();

			if (tmp != null) {
				currentList.add(tmp.data);

				if (tmp.left != null) {
					queue.offer(tmp.left);
				}

				if (tmp.right != null) {
					queue.offer(tmp.right);
				}

			} else {
				ArrayList<Integer> c_currentList = new ArrayList<>(currentList);
				resultArrays.add(c_currentList);
				currentList.clear();
				if (!queue.isEmpty()) {
					queue.offer(null);
				}
			}

		}

		return resultArrays;
	}
	
	    public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) {
		    return result;
		}
		queue.add(root);
		// start the current level
		int level = 0;
		while(!queue.isEmpty()) {
		    result.add(new ArrayList<Integer>());

		    int levelLength = queue.size();

		    for(int i = 0; i< levelLength; i++) {
			TreeNode node = queue.poll();
			 // fulfill the current level
			 result.get(level).add(node.val);
			// add child nodes of the current level
			// in the queue for the next level   
			if(node.left != null) {
			    queue.add(node.left);
			}
			if(node.right != null) {
			    queue.add(node.right);
			}
		    }
				
		    level++;    
		}
		return result;
	    }

	
	public static void main(String[] args) {

	}

}
