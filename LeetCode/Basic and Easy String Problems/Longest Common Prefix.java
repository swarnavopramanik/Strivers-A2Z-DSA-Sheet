14. Longest Common Prefix


  class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}


 class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++) {
            for(String s : strs)
                if(i == s.length() || s.charAt(i) != strs[0].charAt(i))
                    return res.toString();
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}



class Solution3 {
    public boolean check(String[] arr, String str) {
        int count=0;
        for(int i=1;i<arr.length;i++) {
            if(arr[i].contains(str))
                count++;
        }
        if(count >= arr.length-1)
            return true;
        else 
            return false;
    }
    public String remove(String str) {
        StringBuffer sb = new StringBuffer(str);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public boolean prefix(String[] strs, String test) {
        for(int i=0;i<strs.length;i++) {
            if(!strs[i].startsWith(test))
                return false;
        }
        return true;
    }
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparing(s->s.length()));
        //sort the array of strings based on the string's length.
        String test = strs[0]; 
        //assign the shortest string to "test"
        while(!test.equals("")) {
            //run the loop until the test string becomes empty
            int n = strs[0].length();
            //length of the shortest string is stored in "n"
            for(int i=0;i<n;i++) {
                //check whether test is present in all the strings of the array and the string is in prefix.
                if(check(strs,test) && prefix(strs,test)) {
                    return test;
                }
                test  = remove(test);
                //remove the last element for every failure.
            }
        }
        return "";
        
    }
} 
 
 

 
 class Solution4 {
    public String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
 

