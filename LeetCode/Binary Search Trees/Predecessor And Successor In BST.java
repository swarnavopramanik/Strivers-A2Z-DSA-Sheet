https://www.codingninjas.com/studio/problems/predecessor-and-successor-in-bst_893049?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

/*
    Time Complexity : O(N)
    Space Complexity : O(1)

    where 'N' is the number of nodes in the BST.
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        int predecessor = -1;
        int successor = -1;

        // Initializing temporary node with head.
        TreeNode temp = root;

        // Traversing in tree.
        while (temp != null)
        {
            if (key > temp.data)
            {
                // Updating predecessor.
                predecessor = temp.data;
                temp = temp.right;
            }
            else
            {
                temp = temp.left;
            }
        }

        temp = root;

        // Traversing in tree.
        while (temp != null)
        {
            if (key >= temp.data)
            {
                temp = temp.right;
            }
            else
            {
                // Updating successor.
                successor = temp.data;
                temp = temp.left;
            }
        }

        List< Integer > sol = new ArrayList <> ();
        sol.add(predecessor);
        sol.add(successor);
        return sol;
    }
}

-------------------------------------------------------------------------------------------------------------------------------------

 import java.util.*; 

public class Solution {

    public static void inorder(TreeNode root, List<Integer> inorderArr) {

        if (root == null)

            return;

        inorder(root.left, inorderArr);

        inorderArr.add(root.data);

        inorder(root.right, inorderArr);

    }
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {

        List<Integer> inorderArr = new ArrayList<>();

        inorder(root, inorderArr);

        int pre = -1, succ = -1;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < inorderArr.size(); i++) {

            if (inorderArr.get(i) < key) {

                pre = inorderArr.get(i);
            }
            if (inorderArr.get(i) > key) {

                succ = inorderArr.get(i);

                break;
            }
        }
        ans.add(pre);

        ans.add(succ);

        return ans;

    }

} 
