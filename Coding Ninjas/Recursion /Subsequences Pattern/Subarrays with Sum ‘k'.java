https://www.codingninjas.com/studio/problems/subarrays-with-sum-%E2%80%98k'_6922076?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

import java.util.*;
public class Solution {
    public static List<List< Integer >> subarraysWithSumK(int []a, long k) {
        // Write your code here
        //Naive
        // return naive(a, k);

        //Optimised
        return optimised(a, k);
    }

    private static List<List<Integer>> naive(int[] a, long k) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            long sum = 0;
            ArrayList<Integer> sumList = new ArrayList<>();
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                sumList.add(a[j]);
                if (sum == k) {
                    ans.add(sumList);
                    break;
                }
            }
        }
        return ans;
    }

    private static List<List<Integer>> optimised(int[] a, long k) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Long, Integer> sumToIdx = new HashMap<>();
        sumToIdx.put(0l, -1);
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sumToIdx.containsKey((sum-k))) {
                ans.add(createSubarray(a, sumToIdx.get(sum-k)+1, i));
            }
            sumToIdx.put(sum, i);
        }

        return ans;
    }
    private static List<Integer> createSubarray(int[] arr, int s, int e) {
        List<Integer> ans = new ArrayList<>();
        for (int i = s; i <= e; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
