503. Next Greater Element II


  class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>(); // create a stack to store indices of elements

        // first loop to find the next greater element for each element in nums (except the last one)
        for(int i = n-2; i >= 0; i--){

            // while the stack is not empty and the top element is smaller than or equal to the current element in nums
            while(st.size() > 0 && st.peek() <= nums[i]){
                st.pop(); // remove the top element from stack
            }
            st.push(nums[i]); // push the current element in nums into stack
        }

        int ans[] = new int[nums.length];

        // second loop to find the next greater element for the remaining elements (including the last one)
        for(int i = n-1; i >= 0; i--){

            // while the stack is not empty and the top element is smaller than or equal to the current element in nums
            while(st.size() > 0 && nums[i] >= st.peek()){
                st.pop(); // remove the top element from stack
            }
            
            if(st.size() == 0){
                ans[i] = -1; // if stack is empty, set the answer to -1 (no next greater element found)
            }else{
                ans[i] = st.peek(); // otherwise, set the answer to the top element of the stack
            }

            st.push(nums[i]); // push the current element in nums into stack
        }
        return ans; // return the answer array
    }
}
