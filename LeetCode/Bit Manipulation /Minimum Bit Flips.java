2220. Minimum Bit Flips to Convert Number

  class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;
        while(xor > 0){
            count++;
            xor =  xor & (xor-1);
        }

        return count; 
    }
}
