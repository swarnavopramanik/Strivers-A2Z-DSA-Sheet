104. Maximum Depth of Binary Tree

  class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        
        int lh = maxDepth(root.left); 
        int rh = maxDepth(root.right); 
        
        return 1 + Math.max(lh, rh); 
    } 
}


/* class Solution {
    public int maxDepth(TreeNode root) {
             if( root == null ){
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int level = 0;

        while( queue.size() > 0 ){
            int size = queue.size();

            while( size-- > 0 ){
                TreeNode remNode = queue.removeFirst();
                if( remNode.left != null ){
                    queue.addLast( remNode.left );
                }
                if( remNode.right != null ){
                        queue.addLast( remNode.right );
                }
            }

            level++;
        }

        return level;
    }
} */

