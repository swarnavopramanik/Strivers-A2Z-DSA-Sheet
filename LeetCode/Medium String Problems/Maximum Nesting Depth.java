1614. Maximum Nesting Depth of the Parentheses

  class Solution {
    public int maxDepth(String s) {
        int maxi=Integer.MIN_VALUE;
        int res=0;
        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i);
            if(ch=='('){
                res++;
            }else if(ch==')'){
                res--;
            }
            maxi=Math.max(maxi,res);
        }
        return maxi;
    }
}
