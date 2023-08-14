1903. Largest Odd Number in String

   class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        for(int i = n-1; i>=0; i--){
            int x = Character.getNumericValue(num.charAt(i));
            if(x%2 == 1)  { // odd
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
// return the substring from 0 to i+1(which means from that index to the first we have largest odd number).


class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        int l = 0;
        int r = n-1;
        while(r>=l) {
            if((int)num.charAt(r)%2==1) {
                l = r;
                break;
            }
            r--;
        }
        String res = num.substring(0, l+1);

        if(r>=0) {
            return res;
        }
        else {
            return "";
        }
    }
}
