2149. Rearrange Array Elements by Sign


  import java.util.ArrayList;

class Solution {
     public int[] rearrangeArray(int[] nums) {
        int n1 = nums.length / 2;
        ArrayList<Integer> s1 = new ArrayList<>(n1);
        ArrayList<Integer> s2 = new ArrayList<>(n1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                s1.add(nums[i]);
            } else if (nums[i] < 0) {
                s2.add(nums[i]);
            }
        }

        int[] arr1 = new int[nums.length];

        for (int i = 0, j = 0; i < nums.length; i = i + 2) {
            arr1[i] = s1.get(j);
            j++;
        }

        for (int i = 1, j = 0; i < nums.length; i = i + 2) {
            arr1[i] = s2.get(j);
            j++;
        }

        return arr1;
    } 


    /* public int[] rearrangeArray(int[] nums) {
    int s = nums.length;
    int [] arr = new int[s];
    
    int p = 0;  // p = positive
    int n = 1; // n = negative
    for(int i =0;i < s;i++)
    {
        if(nums[i] > 0){
            arr[p] = nums[i];
            p =p+2;
        }else{
            arr[n] = nums[i];
            n = n+2;
        }
    }
    
    return arr;
}

 */

}
