136. Single Number


   /* Approch 1 */ 
 
/*  class Solution {
    public int singleNumber(int[] nums) {
        int ans=0; //since XOR with 0 returns same number 
        for(int i=0; i<nums.length; i++){
            ans ^= nums[i];  // ans = (ans) XOR (array element at i) 
        }
        return ans;    
    }
} 
 */
 
 /* Approch 2 */ 
 
/* class Solution {
   public int singleNumber(int[] nums) {
        int i=0,j=0;
        Arrays.sort(nums);
        for(i=0;i<nums.length-1;i++)
        {
            for(j=i+1;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    i++;
                    break;
                }
                if(j==nums.length-1)
                    return nums[i];
            }
        }
        return nums[nums.length-1];
    }
} 
 
      */

 /* Approch 3 */ 

   /*  class Solution {
     public int singleNumber(int[] nums) {
        //size of the array:

        int n = nums.length;

        // Declare the hashmap.
        // And hash the given array:

        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(nums[i], 0);
            mpp.put(nums[i], value + 1);
        }

        //Find the single element and return the answer:

        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() == 1) {
                   return it.getKey();
            }
        }

        //This line will never execute
        //if the array contains a single element.
        
        return -1;
    }

    };
 */
