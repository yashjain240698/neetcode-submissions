class Solution {
    private boolean helper(String s, int idx, Set<String> st, int lastIdx, int[][] dp) {
        if (idx >= s.length()) {
            String str = s.substring(lastIdx + 1, s.length());
            return st.contains(str);
        }

        if (dp[idx][lastIdx+1] != -1)
            return dp[idx][lastIdx+1] == 1 ? true : false;

        boolean flag = false;
        flag = flag || helper(s, idx + 1, st, lastIdx, dp);

        String str = s.substring(lastIdx + 1, idx + 1);
        if (st.contains(str)) {
            flag = flag || helper(s, idx + 1, st, idx, dp);
        }
        dp[idx][lastIdx+1] = (flag) ? 1 : 0;
        return dp[idx][lastIdx+1] == 1 ? true : false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>(wordDict);
        int[][] dp = new int[s.length()+1][s.length()+1];
        for (int i = 0; i <= s.length(); i++) Arrays.fill(dp[i], -1);
        return helper(s, 0, st, -1, dp);
    }
}
