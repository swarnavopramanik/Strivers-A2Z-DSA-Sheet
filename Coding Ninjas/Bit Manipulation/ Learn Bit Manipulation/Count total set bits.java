https://www.codingninjas.com/studio/problems/count-total-set-bits_784?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

/*
   Space Complexity : O(Log(N))

   where 'N' is the number till which we have to count set bits..
*/
public class Solution{
    public static int countSetBits(int n) {
        // We have 'd' which is the size of repeating window.
        // We are using 'x' to run the loop Log(N) times which is equal to the number of bits in its binary representation.
        int d=2,ans=0,x=n;
        while(x != 0)
        {

            // Using the Mathematical formula explained in the Approach.
            ans+=((n+1)/d)*(d/2) + Math.max((n+1)%d-d/2,0);

            // Window size double every time we shift to the next left bit.
            d*=2;
            x/=2;
        }
        return ans;
    }
}
