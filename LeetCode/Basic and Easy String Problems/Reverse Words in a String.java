151. Reverse Words in a String


  class Solution {
    public String reverseWords(String s) {
       Stack<String> st = new Stack<>();
       String temp = "";
       String ans  = "";
        
       for(int i =0; i <s.length(); i++){
          if(s.charAt(i) == ' '){ 
              if(temp.length() > 0)
               st.push(temp);             
              temp = "";
          }else
             temp = temp + s.charAt(i);
        }
        
        ans = ans + temp;
     
        while(!st.isEmpty()){
            ans = ans + " " + st.pop();
        }
      
        if(ans.length() != 0 && ans.charAt(0) == ' ')
          ans =  ans.substring(1);
        
        return ans;
    }
} 


/*  class Solution {
    public String reverseWords(String s) {
        StringBuilder ans=new StringBuilder();
        for(int start = s.length()-1; start >=0 ; start--) {
            if(s.charAt(start)==' '){
                continue;
            }
            int end=start;
            while(start>=0 && s.charAt(start)!=' '){
                start--;
            }
            ans.append(s.substring(start+1,end+1)).append(" ");
        }
        return ans.toString().strip();
    }
} 
  */
