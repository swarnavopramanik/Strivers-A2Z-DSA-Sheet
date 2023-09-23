https://www.codingninjas.com/studio/problems/job-sequencing-problem_1169460?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

import java.util.*;

public class Solution {

    public static int[] jobScheduling(int [][]jobs) {

      Arrays.sort(jobs,(a,b)->b[2]-a[2]);

       int max=0;

       for(int[] d:jobs)

          max=Math.max(max,d[1]);

    int count=0,profit=0,len=jobs.length;

    boolean deadline[]=new boolean[max+1];    

     for(int i=0;i<len;i++){

         int j=jobs[i][1];

         while(j>0){

             if(!deadline[j]){

                 deadline[j]=true;

                 profit+=jobs[i][2];

                 count++;

                 break;

             }

             j--;

         }

     }

     return new int[]{count,profit};

      

    }

}
