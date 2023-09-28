https://www.codingninjas.com/studio/problems/check-whether-k-th-bit-is-set-or-not_5026446?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf


public class Solution {

    static boolean isKthBitSet(int n, int k) {

        // Bitwise and of 2 bits is true if both bits are true else it is false.
        // So we can check the bitwise and of n and 2^(k-1).
        if ((n & (1 << (k - 1)))!=0) {
            return true;
        } else {
            return false;
        }
    }
}
