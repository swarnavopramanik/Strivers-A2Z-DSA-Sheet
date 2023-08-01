485. Max Consecutive Ones


  class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0; // cnt = count 
        int maxi = 0; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }

            maxi = Math.max(maxi, cnt);
        }
        return maxi;
    }
}
