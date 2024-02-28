653. Two Sum IV - Input is a BST

  
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) return true;
            else if (sum < k) i++;
            else j--;
        }
        return false;
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
