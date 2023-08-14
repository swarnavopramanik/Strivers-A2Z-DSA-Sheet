5. Longest Palindromic Substring


  class Solution1 {
    int maxLen = 0;
    int lo = 0;
    public String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        if(s.length() < 2) {
            return s;
        }
        
        for(int i = 0; i<input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i+1);
        }
        return s.substring(lo, lo+maxLen);
    }
    
    public void expandPalindrome(char[] s, int j, int k) {
        while(j >= 0 && k < s.length && s[j] == s[k]) {
            j--;
            k++;
        }
        if(maxLen < k - j - 1) {
            maxLen = k - j - 1;
            lo = j+1;
        }
    }
} 




 class Solution2 {
    public String longestPalindrome(String s) {
        int currLen = 0, maxLen = 0;
        int n = s.length();
        String longestPalindrome = "";
        
        if(s.length() <= 1){
            return s;
        }
        //Code for odd length palindrome
        for(int centerIndex = 1; centerIndex < n - 1; centerIndex++){
            int leftIndex = centerIndex - 1, rightIndex = centerIndex + 1;
            //Continue while both the indices are in range and  characters are matching
            while(leftIndex >= 0 && rightIndex < n && s.charAt(leftIndex) == s.charAt(rightIndex)){
                leftIndex--;
                rightIndex++;
            }
            //Calculate the current Palindrome length using formula (r - l + 1) 
            currLen = (rightIndex - 1) - (leftIndex + 1) + 1 ;
            //if curr length is greater than the maxLen we have, update longestPalindrome and maxLen
            if(currLen > maxLen){
                maxLen = currLen; 
                longestPalindrome = s.substring(leftIndex + 1, rightIndex);
            }
        }
        //Code for even length palindrome
        for(int centerIndex = 0; centerIndex < n ; centerIndex++){
            int leftIndex = centerIndex, rightIndex = centerIndex + 1;
            while(leftIndex >= 0 && rightIndex < n && s.charAt(leftIndex) == s.charAt(rightIndex)){
                leftIndex--;
                rightIndex++;
            }
            currLen = (rightIndex - 1) - (leftIndex + 1) + 1 ;
            if(currLen > maxLen){
                maxLen = currLen; 
                longestPalindrome = s.substring(leftIndex + 1, rightIndex);
            }   
        }
        //If you didn't find any palindrome then return 1 length palidnrome
        if(longestPalindrome.isEmpty()){
            return s.substring(0,1);
        }
        return longestPalindrome;
    }
} 

// 2 pointers (without DP)

class Solution3 {
    public String longestPalindrome(String s) {
       int start = 0, end = 0;
       for(int i = 0; i < s.length(); i ++) {
           char c = s.charAt(i);
           int left = i;
           int right = i;
           while(left >= 0 && s.charAt(left) == c) left --;
           while(right < s.length() && s.charAt(right) == c) right ++;
           while(left >= 0 && right < s.length()) {
               if(s.charAt(left) != s.charAt(right)) break;
               left --;
               right ++;
           }
           left += 1;
           if(end - start < right - left) {
               start = left;
               end = right;
           }
       } 
       return s.substring(start, end);
    }
}
