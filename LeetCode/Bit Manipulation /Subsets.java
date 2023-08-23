78. Subsets


  // Runtime: 1 ms, faster than 78.66% of Java online submissions
class Solution {
    public List<List<Integer>> subsets(int[] nums) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
       //loop will run for 2^n-1 times
       for(int i=0;i<(1<<n) ; i++)
       {
           ArrayList<Integer> list = new ArrayList<>();
           for(int k=0;k<n;k++)
           {
               if((i & (1<<k))>0)
                   list.add(nums[k]);
           }
               ans.add(new ArrayList<>(list));
       }
       return ans;   
    }
}



 class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<Integer> curr = new ArrayList<Integer>();
		List<List<Integer>> ans = new ArrayList<>();
		rec(arr, 0, curr, ans); // recursive call 
        return ans;
    }
    
    public void rec(int[] arr, int i, List<Integer> curr, List<List<Integer>> ans) {
		if (i == arr.length) {
			ans.add(new ArrayList<Integer>(curr)); // add new value before return 
			return;
		}
		curr.add(arr[i]);
		rec(arr, i + 1, curr, ans); 
		curr.remove(curr.size() - 1); //backtracking 
		rec(arr, i + 1, curr, ans);
        
	}
}
