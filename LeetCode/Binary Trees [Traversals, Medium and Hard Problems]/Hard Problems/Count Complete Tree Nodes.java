222. Count Complete Tree Nodes

  class Solution {

    public int findHeightLeft(TreeNode cur) {
        int hght = 0; 
        while(cur!=null) {
            hght++; 
            cur = cur.left; 
        }
        return hght; 
    }
    
    public int findHeightRight(TreeNode cur) {
        int hght = 0; 
        while(cur!=null) {
            hght++; 
            cur = cur.right; 
        }
        return hght; 
    }

    public int countNodes(TreeNode root) {
         if(root == null) return 0; 
        
        int lh = findHeightLeft(root); 
        int rh = findHeightRight(root); 
        
        if(lh == rh) return (1<<lh) - 1; 
        
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        
        return 1 + leftNodes + rightNodes; 
    }
}

/* class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
    
        int ans = countAllNodes(root);
        return ans;
    }
     int countAllNodes(TreeNode root)
    {
        if(root == null) return 0;
       int lh =  countAllNodes(root.left);
       int rh = countAllNodes(root.right);
        
        return lh + rh + 1;
    }
} */
