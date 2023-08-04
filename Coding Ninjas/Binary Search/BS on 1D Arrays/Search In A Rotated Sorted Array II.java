https://www.codingninjas.com/studio/problems/search-in-a-rotated-sorted-array-ii_7449547?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0


public class Solution {
    public static boolean searchInARotatedSortedArrayII(int []A, int key) {
        int n = A.length; // size of the array.
        for (int i = 0; i < n; i++) {
            if (A[i] == key) return true;
        }
        return false;
    }
}
