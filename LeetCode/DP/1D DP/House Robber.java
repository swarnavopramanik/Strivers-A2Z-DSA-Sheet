198. House Robber

  // Striver Memorization

class Solution {
    public int robutil(int ind, int[] nums, int[] dp){
        if(ind < 0) return 0;
        if(ind == 0) return nums[ind];
        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + robutil(ind-2, nums, dp);
        int nonPick = robutil(ind -1, nums, dp);
        return dp[ind] = Math.max(pick , nonPick);
    }
    public int rob(int[] nums){
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return robutil(n-1, nums, dp);
    }
}




 class Solution {
    public int rob(int[] nums) {
        int rob = 0;
        int norob = 0;

        for(int i=0; i<nums.length; i++){
            int newRob = norob + nums[i];
            int newnoRob = Math.max(norob, rob); // maximum amount of money 
            rob = newRob;
            norob = newnoRob;
        }

        return Math.max(rob, norob);
    }
}


* Approach
1. Use two variables, rob and norob, to keep track of the maximum amount of money robbed with or without robbing the current house.
2. Iterate through each house, and at each step, calculate the maximum amount of money if the current house is robbed (newRob) and if it is not robbed (newNoRob).
3. Update rob and norob for the next iteration.
4. The final result is the maximum amount between the two scenarios: robbing the last house or not robbing it. 

