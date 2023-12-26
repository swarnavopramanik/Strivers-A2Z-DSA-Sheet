700. Search in a Binary Search Tree

    //recursive

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root != null){
            if(val == root.val)
                return root;
            else if(val < root.val)
                return searchBST(root.left, val);
            else
                return searchBST(root.right, val);
        }
        else
            return null;
    }
} 


    /* 
    
    //recursive
     public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return root;
        if (root.val == val)
            return root;
        else if (root.val > val)
            return searchBST(root.left, val);
        else if (root.val < val)
            return searchBST(root.right, val);
        return null;
    } 
    //iterative
  	public TreeNode searchBST(TreeNode root, int val) {
     while(root != null)
      {
        if(root.val == val) return root;
        else if(val < root.val) root = root.left;
        else root = root.right;
      }
    
    return root; 
  } 


 */
