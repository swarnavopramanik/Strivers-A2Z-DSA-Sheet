1004. Max Consecutive Ones III

  class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0 , zero = 0 , ans = 0;
        for(int i = 0 ; i<n ;i++){
            if(nums[i] == 0)
                zero++;
            
            while(zero > k){
                if(nums[left] == 0)
                    zero--;
                left++;
            }  
            ans  = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
