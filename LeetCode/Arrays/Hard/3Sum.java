15. 3Sum


  // Optimal Approach

class Solution {
      public static List<List<Integer>>  threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //remove duplicates:
            if (i != 0 && nums[i] == nums[i - 1]) continue;
 
            //moving 2 pointers:
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans;
    }
}

// Better Approach

/*    Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
           int  k = nums.length-1;
            while(j<k){
                int sum =nums[j]+nums[k];
                if(sum == -nums[i]){
                 res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                 j++; k--;
                }
                else if ( sum >-nums[i]) k--;
                else if (sum<-nums[i]) j++;
            }

        }
        return new ArrayList<>(res);

    } */
