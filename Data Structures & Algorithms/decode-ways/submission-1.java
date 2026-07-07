class Solution {
    private int helper(String s, int idx, int[] dp) {
        if (idx >= s.length())
            return 1;

        if (s.charAt(idx) == '0')
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int cnt = 0;

        cnt += helper(s, idx + 1, dp);

        if (idx + 1 < s.length() && ((s.charAt(idx) - '0' == 1) || (s.charAt(idx) - '0' <= 2
            && s.charAt(idx + 1) - '0' <= 6))) {
            cnt += helper(s, idx + 2, dp);
        }

        return dp[idx] = cnt;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
}
