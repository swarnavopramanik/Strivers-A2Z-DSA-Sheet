64. Minimum Path Sum

   class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        for (int i = 1; i < m; i++) grid[i][0] += grid[i-1][0];
        
        for (int j = 1; j < n; j++) grid[0][j] += grid[0][j-1];
        
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        
        return grid[m-1][n-1];
    }
} 
-----------------------------------------------------------------------------------------------------------
class Solution 
{
    static int[][] memo;
    public int minPathSum(int[][] grid) 
    {
        int m = grid.length-1;
        int n = grid[0].length-1;
        
        memo = new int[m+1][n+1];
        
        return find(grid, m, n, memo);
    }
    public int find(int grid[][], int m, int n, int[][] memo)
    {
        if(m==0 && n==0)
            return grid[0][0];
        
        else if(m<0 || n<0)
            return Integer.MAX_VALUE;
        
        else if(memo[m][n]!=0)
            return memo[m][n];
        else
            return memo[m][n] =  grid[m][n] + Math.min(find(grid, m-1, n, memo),find(grid, m, n-1, memo)); 
}
    }

----------------------------------------------------------------------------------------------------------------------
// Striver Case 1 pass Case 2 wrong

  class Solution {
    public int minPathSumUtill(int i , int j, int[][] grid, int dp[][] ){
        if(i == 0 && j == 0) return grid[0][0];
        if(i < 0 || j < 0) return (int) Math.pow(10, 9);
        if(dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + minPathSumUtill(i-1,j, grid, dp);
        int left = grid[i][j] + minPathSumUtill(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up , left);
    }


    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid.length;
        int[][] dp = new int[n][m];

        for (int row[] : dp)
        Arrays.fill(row, -1);

        return minPathSumUtill(n-1, m-1, grid, dp);
    }
} 
