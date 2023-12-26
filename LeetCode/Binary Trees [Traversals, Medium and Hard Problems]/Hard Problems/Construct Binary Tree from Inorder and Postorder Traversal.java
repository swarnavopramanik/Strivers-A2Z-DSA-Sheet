106. Construct Binary Tree from Inorder and Postorder Traversal

  // Inorder ---> Left > Root > Right 
// Postorder ---> Left > Right > Root 

// Approach 1 ( Striver )

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
 if (inorder == null || postorder == null || inorder.length != 
        postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
                              postorder.length-1,hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder,
    int ps, int pe,HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps,
        ps+ri-is-1, hm);
        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, 
        ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;

    }

}

// Approach 2 

/* class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        return helper(inorder, postorder, 0, len - 1, 0, len - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd)     {
        if (inStart > inEnd) {
            return null;
        }
        
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = inStart;
        for (; rootIndex <= inEnd; rootIndex++) {
            if (inorder[rootIndex] == rootVal) {
                break;
            }
        }
        
        int leftTreeSize = rootIndex - inStart;
        int rightTreeSize = inEnd - rootIndex;
        
        root.left = helper(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftTreeSize - 1);
        root.right = helper(inorder, postorder, rootIndex + 1, inEnd, postEnd - rightTreeSize, postEnd - 1);
        return root;
    }
} */
