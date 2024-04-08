120. Triangle
  
  class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        return recurse(triangle, 0, 0, memo);
    }
    
    private int recurse(List<List<Integer>> triangle, int row, int col, int[][] memo) {
        // base case
        if (row == triangle.size())
            return 0;
        
        if (memo[row][col] != Integer.MAX_VALUE)
            return memo[row][col];
        
int remain = Math.min(recurse(triangle, row + 1, col, memo),
        recurse(triangle, row + 1, col + 1, memo));
        
        memo[row][col] = triangle.get(row).get(col) + remain;
        return memo[row][col];
    }
}
