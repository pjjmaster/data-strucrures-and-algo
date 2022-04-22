package com.practice.google;

public class LevelOrderTreeTraversal{

    List<List<Integer>> levels = new ArrayList<>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return levels;
        }
        levelOrderRec(root, 0);
        return levels;
    }
    
    public void levelOrderRec(TreeNode node, int level) {
        if(levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
        
        levels.get(level).add(node.val);
        if(node.left != null) {
            levelOrderRec(node.left, level + 1);
        }
        if(node.right != null) {
            levelOrderRec(node.right, level + 1);
        }
    }

  
  //Iterative solution
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
  

}
