https://www.codingninjas.com/studio/problems/subset-sum_630213?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class Solution {
    public static boolean isSubsetPresent(int n, int k,int []a) {
           int[][] dp = new int[n+1][k+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<k+1; j++){
                if(i==0){
                    dp[i][j]=0;
                }else if(j==0){
                    dp[i][j]=1;
                }else if(a[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j-a[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        if(dp[n][k]==1){
            return true;
        }else
        return false;
    }
}
