https://www.codingninjas.com/studio/problems/-binary-strings-with-no-consecutive-1s._893001?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.List;

public class Solution {
    public static List< String > generateString(int N) {
        // Write your code here.
        int a[N+1], b[N+1];
    a[0] = b[0] = 0;
	a[1]=b[1]=1;
    for (int i = 2; i < N; i++)
    {
        a[i] = a[i-1] + b[i-1];
        b[i] = a[i-1];
    }
    return a[N-1] + b[N-1];
    }
}
