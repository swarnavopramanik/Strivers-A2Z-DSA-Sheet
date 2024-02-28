230. Kth Smallest Element in a BST


   class Solution {
    public int kthSmallest(TreeNode root, int k) {
      int count = countNodes(root.left);
      if (k <= count) {
          return kthSmallest(root.left, k);
      } else if (k > count + 1) {
          return kthSmallest(root.right, k-1-count); 
          // 1 is counted as current node
      }
      
      return root.val;
  }
  
  public int countNodes(TreeNode n) {
      if (n == null) return 0;
      
      return 1 + countNodes(n.left) + countNodes(n.right);
  }
} 

// ------------------------------------------------------------------------ //

class Solution {
    List<Integer> list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return 0;
        help(root,k);
        return list.get(k-1);
    }
    public void help(TreeNode root,int k)
    {
        if(root==null)return;
        help(root.left,k);
        list.add(root.val);
        if(list.size()==k)return;
        help(root.right,k);
    }
}
