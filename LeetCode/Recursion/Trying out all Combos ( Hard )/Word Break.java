139. Word Break


  // Dynamic Programming

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int max_len = 0;
        for (String word : wordDict) {
            max_len = Math.max(max_len, word.length());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i - max_len - 1, 0); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}

// Depth-First Search with Memoization

/* class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> hm = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet, hm);
    }
    
    private boolean dfs(String s, Set<String> wordSet, Map<String, Boolean> hm) {
        if (hm.containsKey(s)) return hm.get(s);
        if (wordSet.contains(s)) return true;
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordSet.contains(prefix) && dfs(s.substring(i), wordSet, hm)) {
                hm.put(s, true);
                return true;
            }
        }
        hm.put(s, false);
        return false;
    }
} */
