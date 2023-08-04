https://www.codingninjas.com/studio/problems/ceiling-in-a-sorted-array_1825401?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0

import java.util.*;
public class Solution {

    // floor 

    static int floor(int n, int x, int[] arr) {

        int l = 0 ;

        int r = n ;

        int ans = -1 ;

        while(l < r) {

            int mid = l + (r-l)/2 ;

 

            if(arr[mid] <= x) {

                ans = arr[mid] ;

                l = mid+1 ;

            }

            else  {

                r = mid ;

            }

        }

        return ans ;

    }

    // ceil  

    static int ceil(int n, int x, int[] arr) {

        int l = 0 ;

        int r = n ;

        int ans = -1 ;

        while(l < r) {

            int mid = l + (r-l)/2 ;

 

            if(arr[mid] >= x) {

                ans = arr[mid] ;

                r = mid ;

            }

            else  {

                l = mid+1 ;

            }

        }

        return ans ;

    }

    public static int ceilingInSortedArray(int n, int x, int[] arr) {

        Arrays.sort(arr) ;

        int fl = floor(n,x,arr) ;

        int c = ceil(n,x,arr) ;

 

        System.out.print(fl+" ");

        return c ;

    }

}
