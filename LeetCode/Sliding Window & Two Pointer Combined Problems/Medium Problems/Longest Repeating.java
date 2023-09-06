424. Longest Repeating Character Replacement


  class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0; 
        int maxCount = 0;// current max count from the sliiding window 
        int maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']); //~ increase the count of the number
            while (end - start + 1 - maxCount > k) { // move start to reduce window
                count[s.charAt(start) - 'A']--; // increase the start value
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
