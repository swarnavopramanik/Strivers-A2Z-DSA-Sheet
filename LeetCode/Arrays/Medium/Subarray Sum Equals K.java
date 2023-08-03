560. Subarray Sum Equals K


  //O(N2)

 class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length; // size of the given array.
        int cnt = 0; // Number of subarrays:

        for (int i = 0 ; i < n; i++) { // starting index i
            int sum = 0;
            for (int j = i; j < n; j++) { // ending index j
                // calculate the sum of subarray [i...j]
                // sum of [i..j-1] + arr[j]
                sum += nums[j];

                // Increase the count if sum == k:
                if (sum == k)
                    cnt++;
            }
        }
        return cnt;
    }

}
 

// O(N) or O(N*logN)

/* class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        int ans=0,currPrefix=0;
        prefixSum.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            currPrefix+=nums[i];
            ans+=prefixSum.getOrDefault(currPrefix-k,0);
            prefixSum.put(currPrefix,prefixSum.getOrDefault(currPrefix,0)+1);
        }
        return ans;
    }
} 

*/
