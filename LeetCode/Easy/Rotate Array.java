189. Rotate Array

  class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        k = k % N;
        reverse(nums, 0,N-1);
        reverse(nums , 0 , k-1);
        reverse(nums , k, N-1);
    }
    public void reverse(int nums[] , int start, int end){
        
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
