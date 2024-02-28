173. Binary Search Tree Iterator

  
class BSTIterator {
	Stack<TreeNode> stack;
	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		TreeNode node = root;
		updateStack(node);    // update stack
	}
	public int next() {
		TreeNode toRemove = stack.pop();
		updateStack(toRemove.right);
        // before return node, first update stack further        
		return toRemove.val;
	}
	public boolean hasNext() {
		return !stack.isEmpty();    
	}
	// -------------------
	public void updateStack(TreeNode node){
		while(node != null){
			stack.add(node);
			node = node.left;
		}
	}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
