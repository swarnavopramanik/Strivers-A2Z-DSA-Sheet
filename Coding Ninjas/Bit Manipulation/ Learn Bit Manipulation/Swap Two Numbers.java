https://www.codingninjas.com/studio/problems/swap-two-numbers_1380853?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

/* public class Solution{
    public static void swapNumber(int []a, int []b) {
        int temp = a[0];
        a[0] = b[0];
        b[0] = temp;
    }
} 

*/

public class Solution{

    public static void swapNumber(int []a, int []b) {

        if (a.length != b.length) {

        return;

    } 

    for (int i = 0; i < a.length; i++) {

        a[i] = a[i] ^ b[i];

        b[i] = a[i] ^ b[i];

        a[i] = a[i] ^ b[i];
 
    }

}

}
