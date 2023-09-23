https://www.codingninjas.com/studio/problems/print-all-divisors-of-a-number_1164188?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;
public class Solution{
    public static List< Integer > printDivisors(int n) {
    List<Integer> li = new ArrayList<Integer>();

       for(int i=1;i<=n;i++){
           if(n%i == 0){
               li.add(i);
           }
       }
       return li;
    }
}
