https://www.codingninjas.com/studio/problems/prime-factorisation_1760849?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

/*
   Time Complexity: O(Nlog(log(N))).
   Space Complexity: O(N).

   where 'N' is the given number.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List< Integer > countPrimes(int n) {
        boolean []isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        List< Integer > ans = new ArrayList<>();

        // Counting prime numbers less than 'N'.
        int count = 0;
        for (int i = 2; i < n; i++)
        {
            if (isPrime[i] == true)
            {
                if(n % i == 0) {
                    ans.add(i);
                }
                for (int j = i * 2; j < n; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }
        return ans;
    }
}
