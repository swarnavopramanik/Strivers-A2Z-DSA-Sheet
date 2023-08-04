540. Single Element in a Sorted Array

  class Solution {
    public int singleNonDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++)
        {
            if(s.contains(nums[i]))
            {
                s.remove(nums[i]);
            }
            else
            {
                s.add(nums[i]);
            }
        }

        Iterator<Integer> it = s.iterator();
        while (it.hasNext()) 
        {
            return it.next();
        }
        return -1;
    }
}
