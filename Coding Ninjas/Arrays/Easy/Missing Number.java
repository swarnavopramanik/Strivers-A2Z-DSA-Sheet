https://www.codingninjas.com/studio/problems/missing-number_6680467?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTab=0

public class Solution {
    public static int missingNumber(int []a, int N) {
          //Summation of first N numbers:
        int sum = (N * (N + 1)) / 2; // Summation of 1 to 5 = (5*(5+1))/2 = 15 ( for 1st example )

        //Summation of all array elements:
        int s2 = 0;
        for (int i = 0; i < N - 1; i++) {
            s2 += a[i]; // Summation of array elements = 12 ( for 1st example )
        }

        int missingNum = sum - s2; // the difference will be = 15 - 12 = 3 ( for 1st example )
        return missingNum;
}

}
