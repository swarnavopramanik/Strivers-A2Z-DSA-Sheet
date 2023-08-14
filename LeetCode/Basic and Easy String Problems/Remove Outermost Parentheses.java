1021. Remove Outermost Parentheses

  class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                level++;
            }
            if(level > 1){
                sb.append(s.charAt(i));
            }
            if(s.charAt(i) == ')'){
                level--;
            }
        }
        return sb.toString();
    }
}
