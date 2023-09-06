76. Minimum Window Substring


   class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() ==0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE,startIndex =0;
        for (char c :t.toCharArray()) {
            map[c]++;
        }
        char[] chS = s.toCharArray();
        while (end < chS.length) {
            if (map[chS[end++]]-- >0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE? new String():
                new String(chS,startIndex,minLen);
    }
} 


---------------------------------------------------------------------------------------------------------------------------------------------

 class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count=0,start=0,min_length = Integer.MAX_VALUE, min_start = 0;
        for(int end=0; end<s.length(); end++){
            if(map.containsKey(s.charAt(end))){
                if(map.get(s.charAt(end))>0){
                    count++;
                }
                map.put(s.charAt(end), map.get(s.charAt(end))-1); 
            }
            if(count == t.length()) { 
                while(start < end && (!map.containsKey(s.charAt(start)) || map.get(s.charAt(start)) < 0)){
                    if(map.containsKey(s.charAt(start)))
                        map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    }
                    start++;
                } 
                if(min_length > end-start+1){
                    min_length = end-(min_start=start)+1; 
                }
                if(map.containsKey(s.charAt(start))){
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                }
                count--;
                start++;
            }
        }
        return min_length == Integer.MAX_VALUE ? "" : s.substring(min_start, min_start+min_length);
    }
} 

