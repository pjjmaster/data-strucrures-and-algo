package com.practice.trees;

public class TreeFromInOrderAndPostOrder {

	static class Index {
		int index;
	}

	public static TreeNode contructBinaryTree(int[] inOrder, int[] postOrder) {

		if (inOrder.length == 0) {
			return null;
		}

		int n = inOrder.length;
		Index postOrderIndex = new Index();
		postOrderIndex.index = n;
		binaryUtil(inOrder, postOrder, 0, n - 1, postOrderIndex);

		return null;
	}

	private static TreeNode binaryUtil(int[] inOrder, int[] postOrder, int inOrderStart, int inOrderEnd,
			Index postOrderIndex) {

		if (inOrderStart > inOrderEnd) {
			return null;
		}
		// Get the rootNode
		TreeNode root = new TreeNode(postOrder[postOrderIndex.index]);
		postOrderIndex.index--;
		// check the node in inorder
		int inOrderIndex = search(inOrder, inOrderStart, inOrderEnd, root.val);

		root.left = binaryUtil(inOrder, postOrder, inOrderStart, inOrderIndex - 1, postOrderIndex);
		root.right = binaryUtil(inOrder, postOrder, inOrderIndex + 1, inOrderEnd, postOrderIndex);
		return root;
	}

	private static int search(int[] inOrder, int inOrderStart, int inOrderEnd, int val) {
		int i = 0;
		for (i = inOrderStart; i < inOrderEnd; i++) {
			if (inOrder[i] == val) {
				break;
			}
		}

		return i;
	}

}
