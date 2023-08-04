33. Search in Rotated Sorted Array


  class Solution {
    public int search(int[] nums, int target) {
        int ans = bs(nums, target, 0, nums.length-1);
        return ans;   
        }

    int bs(int[] nums, int t, int s, int e){
        if(s>e) return -1;
        
        int mid = s + (e-s)/2;
        if(nums[mid]==t) return mid;
        // check if we are in left sorted array
        if(nums[mid]>=nums[s]){
            // check target is in left sorted array
            if(t>=nums[s] && t<=nums[mid]){
                return bs(nums, t, s, mid-1);
            }
            return bs(nums, t, mid+1, e);
        }
        else{
            if(t>=nums[mid] && t<=nums[e]){
                return bs(nums, t, mid+1, e);
            }
            return bs(nums, t, s, mid-1);
        }

    }

}

/*  bs = binary search 
     s = start 
     e = end 

 */

// [0,1,2,4,5,6,7]
// rotate by 1 time - [1,2,4,5,6,7,0]
// 2 times- [2,4,5,6,7,0,1]

// [4,5,6,7          ,0,1,2] 
// start          mid         end
// check mid is greater than start
//         check target greater than start and less than mid{
//             put end as mid-1
//         }
//         else(put start as mid+1)
// else
//     check target is greater than mid and less than end{
//         start = mid+1
//     }
//     else end = mid-1;
