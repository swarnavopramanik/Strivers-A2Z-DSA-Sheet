https://www.codingninjas.com/studio/problems/power-of-two_893061?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class Solution {
    public static boolean isPowerOfTwo(int n) {
       
      /*  return (n & (n-1)) == 0; */

      if(n < 1)
            return false;
        if(n == 1)
            return true;
        if(n %2 ==1)
            return false;
        return (isPowerOfTwo(n/2)); 
        
    }
}
