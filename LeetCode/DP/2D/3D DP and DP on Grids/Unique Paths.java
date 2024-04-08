62. Unique Paths


  // Striver 

class Solution {
    public int uniquePathsUtill(int i,int j,int dp[][]){
        if(i == 0 && j == 0)
        return 1;
        if(i < 0 || j < 0)
        return 0;
        if(dp[i][j] != -1)
        return dp[i][j];

        int up = uniquePathsUtill(i-1,j, dp);
        int left = uniquePathsUtill(i, j-1, dp);

        return dp[i][j] = up + left;
    }
     
    public int uniquePaths(int m, int n){
        int dp[][] = new int[m][n];
        for(int[] row : dp)
        Arrays.fill(row, -1);
        return uniquePathsUtill(m-1, n-1, dp);
    }
}

----------------------------------------------------------------------------------------------------------------------------
class Solution {
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

           for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i < 0 || j < 0)
                return 0;
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];
                dp[i][j] = up + left;
    }
}
  return dp[m - 1][n - 1];

    }

}
