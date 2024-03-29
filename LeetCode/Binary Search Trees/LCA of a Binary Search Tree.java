235. Lowest Common Ancestor of a Binary Search Tree

  class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        //  If above 2 conditions doesn't satisfy then 
        //  2 cases will arise. For them we simply return 
        //  the current node.
        return root;
    }
}
