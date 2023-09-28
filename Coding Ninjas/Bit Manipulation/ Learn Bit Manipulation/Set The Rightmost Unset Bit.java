https://www.codingninjas.com/studio/problems/set-the-rightmost-unset-bit_8160456?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

/* 
    Time Complexity : O(log N)
    Space Complexity : O(1)
    where 'N' is the given input
*/
public class Solution {
    public static int setBits(int N){
        int x=N;

        // Find the position of the east significant unset bit.
        while((x&1)!=0)
        {
            x=x>>1;
        }

        // Check if there's any unset bit, if not return 'N'
        if(x==0)
        {
            return N;
        }

        // Set the least significant unset bit of 'N' to 1 and return.
        return N | (N+1);
    }
}


/*public class Solution {
    public static int setBits(int N){
        // Check if there's any unset bits.
        if((N & (N+1)) == 0)
            return N;

        // Set the least significant unset bit of 'N' to 1 and return.
        return N | (N+1); 

Time Complexity : O(1)
Space Complexity : O(1
        
        
        /* 
