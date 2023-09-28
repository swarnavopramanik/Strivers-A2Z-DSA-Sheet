/*
    Time Complexity : O(1)
    Space Complexity : O(1)
*/

public class Solution {
    public static String oddEven(int N){
        if(N%2==1)
            return "odd";
        else
            return "even";
    }
} 

// Bit manipulation


/*
    Time Complexity : O(1)
    Space Complexity : O(1)
*/
public class Solution {
    public static String oddEven(int N){
        if((N&1)==1)
            return "odd";
        else
            return "even";
    }
}
