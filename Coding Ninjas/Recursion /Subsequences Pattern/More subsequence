https://www.codingninjas.com/studio/problems/more-subsequence_8842355?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.ArrayList;

 public class Solution {
    public static String moreSubsequence(int n, int m, String a, String b)
    {
        int countA = countDistinctSubsequences(a);

        int countB = countDistinctSubsequences(b); 

        if (countA >= countB) {

            return a;
        } 

        return b;
    }
        public static int countDistinctSubsequences(String s) {

        int n = s.length();

        int[] dp = new int[n + 1];

        int[] last = new int[26]; // To store the last index of each character in the string
 
        dp[0] = 1; // Empty subsequence

        for (int i = 1; i <= n; i++) {

            dp[i] = 2 * dp[i - 1];

            char ch = s.charAt(i - 1);

            if (last[ch - 'a'] > 0) {

                dp[i] -= dp[last[ch - 'a'] - 1];

            }

            last[ch - 'a'] = i;

        }
 
        return dp[n];

    }

}     
