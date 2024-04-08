416. Partition Equal Subset Sum

  // Strivver 

class Solution {
    private boolean canPartitionUtil(int ind, int target,int[] nums, int[][] dp ){
        if(target == 0) 
        return true;
        if(ind == 0) 
        return nums[0] == target;
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean notTaken = canPartitionUtil(ind -1, target, nums, dp);
        boolean taken = false;
        if(nums[ind] <= target )
        taken = canPartitionUtil(ind -1, target - nums[ind], nums, dp);

         dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }


    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0; i<n; i++){
            totalSum += nums[i];
        }
        if(totalSum  % 2 == 1)
        return false;
        else{
            int s = totalSum / 2;
            int dp[][] = new int[n][s + 1];
            for (int row[] : dp)
            Arrays.fill(row, -1);
            return canPartitionUtil(n - 1, s, nums, dp);
        }
    }
}
