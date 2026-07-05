class Solution {
    private int helper(int[] coins, int target, int idx, int[][] dp) {
        if (target == 0)
            return 1;
        if (target < 0 || idx >= coins.length)
            return 0;

        if (dp[target][idx] != -1)
            return dp[target][idx];

        int ans = 0;
        ans += helper(coins, target, idx + 1, dp);
        ans += helper(coins, target - coins[idx], idx, dp);

        return dp[target][idx] = ans;
    }
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] dp = new int[amount + 1][coins.length+1];
        for(int i = 0 ; i<amount+1 ; i++)
            Arrays.fill(dp[i], -1);
        return helper(coins, amount, 0, dp);
    }
}
