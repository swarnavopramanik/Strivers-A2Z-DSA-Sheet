98. Validate Binary Search Tree

  public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}

---------------------------------------------------------------------------------------------------------------------------

  class Solution {
    private long minVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true; 
        if (!isValidBST(root.left)) return false;
        
        if (minVal >= root.val) return false; 

        minVal = root.val;

        if (!isValidBST(root.right)) return false;

        return true;
    } 
} 



