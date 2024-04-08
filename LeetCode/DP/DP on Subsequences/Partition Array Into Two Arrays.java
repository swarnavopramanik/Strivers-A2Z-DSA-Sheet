2035. Partition Array Into Two Arrays to Minimize Sum Difference

  // Memory Limit Exceeded
class Solution {
    public int minimumDifference(int[] nums) {
        int sum=0;
        
        for(int i=0; i<nums.length; i++)
            sum+=nums[i];
        
        List<Integer> list=new ArrayList<>();
        f(nums, 0, 0, 0, list);
        
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<=list.size()/2; i++) 
            ans=Math.min(ans, Math.abs(sum-list.get(i)-list.get(i)));
        
        return ans;
    }
    void f(int[] nums, int i, int sum, int l, List<Integer> list) {
        if(l == nums.length/2) {
            list.add(sum);
            return;
        }
        if(i == nums.length) 
            return;
        
        f(nums, i+1, sum+nums[i], l+1, list);
        f(nums, i+1, sum, l, list);
    }
}

 // Striver

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += nums[i];
        }

        boolean[][] dp = new boolean[n][totSum + 1];
        for (int i = 0; i <= totSum; i++) {
            dp[0][i] = (i == nums[0]);
        }
        for (int ind = 1; ind < n; ind++) {
        for (int target = 0; target <= totSum; target++) {
                boolean notTaken = dp[ind - 1][target];      
                boolean taken = false;
                if (nums[ind] <= target) {
                    taken = dp[ind - 1][target - nums[ind]];
                }

                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
}
