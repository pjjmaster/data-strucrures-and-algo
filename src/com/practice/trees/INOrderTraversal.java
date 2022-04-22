package com.practice.trees;

public class INOrderTraversal {

	public static void inorderTraversal(TreeNode root) {
		
		if(root==null) {
			return;
		}
		
		inorderTraversal(root.left);
		System.out.print(root.val);
		inorderTraversal(root.right);
	}
	
        private void inorder(TreeNode root, List<Integer> result) {
            Stack<TreeNode> stack = new Stack<>();

            while(true) {              
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                
                if(stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                result.add(root.val);
                root = root.right;
            }        
        }
	
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);

		inorderTraversal(root);
	}
}
