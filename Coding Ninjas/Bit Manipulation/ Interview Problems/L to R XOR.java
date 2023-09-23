https://www.codingninjas.com/studio/problems/l-to-r-xor_8160412?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class Solution {
    public static int findXOR(int L, int R){
        return (XOR(L-1)^XOR(R));

    }

    public static int XOR (int n){

        if(n%4==0) return n;

        else if(n%4==1) return 1;

        else if(n%4==2) return n+1;

        else return 0;
    }
}
