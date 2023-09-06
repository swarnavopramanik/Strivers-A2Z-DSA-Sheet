930. Binary Subarrays With Sum

  class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0, wideSum=0, wideLeft=0, narrowLeft=0;

        for(int right=0;right<nums.length;right++){;

            wideSum += nums[right];

            while(wideSum>goal){
                wideSum -= nums[wideLeft];
                wideLeft++;
            }

    while(narrowLeft<right && (narrowLeft<wideLeft || nums[narrowLeft]==0)){
                narrowLeft++;
            }

            if(wideSum==goal){
                count += narrowLeft-wideLeft+1;
            }
        }

        return count;

    }
}


--------------------------------------------------------------------------------------------------------------------------------------------

 class Solution {

public int numSubarraysWithSum(int[] nums, int goal) {
    if (nums == null || nums.length == 0) return 0;
    final int N = nums.length;
    int[] count = new int[N + 1];
    count[0] = 1;
    int res = 0;
    int sum = 0;
    for (int i = 0; i < N; i++) {
        sum += nums[i];
        if (sum >= goal) {
            res += count[sum - goal];
        }
        count[sum]++;
    }
    return res;
}
} 

