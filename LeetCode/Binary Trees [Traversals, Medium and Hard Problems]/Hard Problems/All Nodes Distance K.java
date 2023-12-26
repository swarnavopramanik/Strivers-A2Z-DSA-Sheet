863. All Nodes Distance K in Binary Tree

  class Solution {
    List<Integer> res=new ArrayList<Integer>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        help(root,target.val,k);
        return res;
    }
    int help(TreeNode node, int t, int k){
        if(node==null) return k;
        if(node.val==t){
            storeK(node,k);
            return k-1;
        }
        int k1=help(node.left,t,k), k2=help(node.right,t,k);
        if(k1!=k2){
            if(Math.min(k1,k2)==0){
                res.add(node.val);
                return k;
            }else if(k1<k) storeK(node.right,k1-1);
            else storeK(node.left,k2-1);
            return Math.min(k1,k2)-1;
        }
        return k;
    }
    void storeK(TreeNode node, int k){
        if(node==null) return;
        if(k==0) res.add(node.val);
        else{
            storeK(node.left,k-1);
            storeK(node.right,k-1);
        }
    }
}
