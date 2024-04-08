494. Target Sum

  // Striver

class Solution {
    public static int findTargetSumWaysUtil(int ind, int target, int[] nums, int[][] dp) {
        if (ind == 0) {
            if (target == 0 && nums[0] == 0)
                return 2;
      
            if (target == 0 || target == nums[0])
                return 1;
            return 0;
        }
        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTaken = findTargetSumWaysUtil(ind - 1, target, nums, dp);

        int taken = 0;

        if (nums[ind] <= target)
            taken = findTargetSumWaysUtil(ind - 1, target - nums[ind], nums, dp);

        return dp[ind][target] = (notTaken + taken);
    }


    public int findTargetSumWays(int[] nums, int target) {
    int n = nums.length;
    int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += nums[i];
        }

        // Checking for edge cases
       
        if (totSum - target < 0)
            return 0;
        if ((totSum - target) % 2 == 1)
            return 0;

       
        int s2 = (totSum - target) / 2;

     
        int dp[][] = new int[n][s2 + 1];

      
        for (int row[] : dp)
        Arrays.fill(row, -1);
        return findTargetSumWaysUtil(n - 1, s2, nums, dp);
          
    }
}
