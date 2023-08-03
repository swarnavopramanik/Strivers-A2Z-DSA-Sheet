https://www.codingninjas.com/studio/problems/longest-subarray-with-zero-sum_6783450?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

public class Solution {
    public static int getLongestZeroSumSubarrayLength(int []arr){
        int  max = 0;
	for(int i = 0; i < arr.length; ++i){
		int sum = 0;
		for(int j = i; j < arr.length; ++j){
			sum += arr[j];
			if(sum == 0){
				max = Math.max(max, j-i+1);
			}
		}
	}
	return max;
   }
 }
