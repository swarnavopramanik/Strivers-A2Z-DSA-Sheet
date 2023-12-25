124. Binary Tree Maximum Path Sum

  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ans =new int[1];
        ans[0]=Integer.MIN_VALUE;
        path(root,ans);
        return ans[0];
    }
    int path(TreeNode root, int[] ans) {
        if (root==null){
            return 0;
        }
        // - Here taken 0 . Since, we will not be considering the -ve values
        int left=Math.max(0,path(root.left,ans));
        int right=Math.max(0,path(root.right,ans));
        // - Updating the max Value here
        ans[0]=Math.max(ans[0],left+right+root.val);
        // - Using recursion so, return the node values to previous ones.
        return Math.max(left,right)+root.val;
    }
}
