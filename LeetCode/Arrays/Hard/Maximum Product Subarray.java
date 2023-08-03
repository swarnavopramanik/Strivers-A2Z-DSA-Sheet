152. Maximum Product Subarray


  class Solution {
    public int maxProduct(int[] nums) {
       
        int maxLeft = nums[0];
	    int maxRight = nums[0];
	    
	    boolean zeroPresent = false;
	    
	    int prod = 1;
	    
	    for(int i:nums) {
	        prod *= i;
	        if(i == 0) {
	            zeroPresent = true;
	            prod = 1;
	            continue;
	        }
	        maxLeft = Math.max(maxLeft,prod);
	    }
	    
	    prod = 1;
	    
	    for(int j=nums.length-1;j>=0;j--) {
	        prod *= nums[j];
	        if(nums[j] == 0) {
	            zeroPresent = true;
	            prod = 1;
	            continue;
	        }
	        maxRight = Math.max(maxRight,prod);
	    }
	    
	    if(zeroPresent) return Math.max(Math.max(maxLeft,maxRight),0);
	    return Math.max(maxLeft,maxRight);
	}
}

// 2nd Approach 
   
   /*  int maxf = nums[0], minf = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int m = maxf, n = minf;
            maxf = Math.max(nums[i], Math.max(m * nums[i], n * nums[i]));
            minf = Math.min(nums[i], Math.min(m * nums[i], n * nums[i]));
            result = Math.max(result, maxf);
        }
        return result; */
    
