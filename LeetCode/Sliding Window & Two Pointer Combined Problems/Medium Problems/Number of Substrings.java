1358. Number of Substrings Containing All Three Characters


  class Solution {
    public int numberOfSubstrings(String s) {
        
int[] track = new int[3]; //also we can use 3 variables for counting (a, b, c)
        int res = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            track[s.charAt(i) - 'a']++;

            while (track[0] > 0 && track[1] > 0 && track[2] > 0) {
                res += s.length() - i;
                track[s.charAt(left++) - 'a']--;
            }
        }
        return res;
    }
}

----------------------------------------------------------------------------------------------------------------------------------------------

  
  class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, start = 0, end = 0;
        int n = s.length();
        while (end < n) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.getOrDefault('a', 0) > 0
                    && map.getOrDefault('b', 0) > 0
                    && map.getOrDefault('c', 0) > 0) {
                count += n - end;
                c = s.charAt(start);
                map.put(c, map.get(c) - 1);
                start++;
            }
            end++;
        }
        return count;
    }
}


