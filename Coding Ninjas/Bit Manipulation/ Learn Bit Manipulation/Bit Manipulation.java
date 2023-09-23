https://www.codingninjas.com/studio/problems/bit-manipulation_8142533?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

public class Solution {
    public static int[] bitManipulation(int num, int i){
        int[] arr=new int[3];

        arr[0]=((num&(1<<i-1))>=1)?1:0;

        arr[1]=num|(1<<i-1);

        arr[2]=num&~(1<<i-1);

        return arr;
    }
}


/*  public class Solution {

    public static int[] bitManipulation(int num, int i){

        int ans[]=new int[3];

        int n=1<<(i-1);

        int bit=num&n;

        if(bit>0)ans[0]=1;

        else

        ans[0]=0;

        if(ans[0]==0){

            ans[2]=num;

            int p=num|n;

            ans[1]=p;

           

        }

        else{

            ans[1]=num;

            int p=num&(~n);

            ans[2]=p;

        }

        return ans;

    }

} */
