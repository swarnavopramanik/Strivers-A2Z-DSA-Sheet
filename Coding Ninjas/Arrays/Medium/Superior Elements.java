https://www.codingninjas.com/studio/problems/superior-elements_6783446?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

import java.util.*;

public class Solution {
    public static List< Integer > superiorElements(int []a) {
         
  ArrayList<Integer> ans= new ArrayList<>();
  
   // Last element of an array is always a leader,
   // push into ans array.
    int n= a.length;
   int max = a[n - 1];

    ans.add(a[n-1]);
    
    // Start checking from the end whether a number is greater
    // than max no. from right, hence leader.
    for (int i = n - 2; i >= 0; i--)
      if (a[i] > max) {
        ans.add(a[i]);
        max = a[i];
      }

  return ans;
   
}

}
