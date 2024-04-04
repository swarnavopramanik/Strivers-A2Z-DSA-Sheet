921. Minimum Add to Make Parentheses Valid

  
class Solution {
    public int minAddToMakeValid(String s) {
        int openingBracket = 0;
        int closingBracket = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') {
               closingBracket++;
            }else{
                if(closingBracket == 0){
                    openingBracket++;
                }else{
                    closingBracket--;
                }
            }
        }

        return openingBracket + closingBracket;
    }
}
