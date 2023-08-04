153. Find Minimum in Rotated Sorted Array

  class Solution {
	public int findMin(int [] nums ) {
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            //if left part is sorted:
            if (nums[low] <= nums[mid]) {
                // keep the minimum:
                ans = Math.min(ans, nums[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, nums[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }
}

// 2nd Approach 

 /* public int findMin(int[] nums) {
	int s = 0; // s = start
    int e = nums.length -1; // e = end 
	while(s < e){
		int m= s+ (e - s)/2;
		if(nums[m]>nums[e]) s = m+1;
		else e = m; // (nums[m] <= nums[e])
	}
	return nums[s];
 } */
