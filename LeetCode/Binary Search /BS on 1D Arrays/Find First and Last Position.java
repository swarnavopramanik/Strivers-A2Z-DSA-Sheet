34. Find First and Last Position of Element in Sorted Array


  class Solution {
    public int[] searchRange(int[] nums, int target)  {
        int[] ans = {-1, -1};

        // check for 1st occurance
        int start = search(nums, target, true);
        int end = search(nums, target, false);

        ans[0] = start;
        ans[1] = end;

        return ans;

    }
    static int search(int[] nums, int target, boolean firstOccurance){
        int ans =  -1;
        int start = 0; 
       int end = nums.length - 1;

        while (start <= end){
//            int mid = (start + end) / 2; // sometimes the mid element value might exceed the range of Int datatype
            int mid = start + (end - start) / 2;

            if (target < nums[mid]){
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            }
            else {
                // potential ans found
                ans = mid;
                if(firstOccurance){
                    end = mid - 1;
                } else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

}

// 2nd Method 

/*        int c=-1,d=-1;;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                c=i;
                break;
            }
        }
         for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==target){
                d=i;
                break;
            }
        }
        int a[]=new int[2];
        for(int i=0;i<2-1;i++){
            a[i]=c;
            a[i+1]=d;
        }
        return a;
    }
}
   */  
 
