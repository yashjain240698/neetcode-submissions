class Solution {
    private int helper(int[] prices, boolean buy, int idx, int cooldown, int[][][] dp) {
        if (idx >= prices.length) {
            return 0;
        }

        int cost;
        int k = buy ? 1 : 0;

        if(dp[idx][k][cooldown] != -1){
            return dp[idx][k][cooldown];
        }
        if (buy) {
            if (cooldown == 1) {
                cost = helper(prices, buy, idx + 1, 0, dp);
            } else {
                cost = Math.max(-prices[idx] + helper(prices, !buy, idx + 1, cooldown, dp),
                    helper(prices, buy, idx + 1, cooldown, dp));
            }
        } else {
            cost = Math.max(prices[idx] + helper(prices, !buy, idx + 1, 1, dp),
                helper(prices, buy, idx + 1, cooldown, dp));
        }

        return dp[idx][k][cooldown] = cost;
    }
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][3][3];
        for(int i = 0 ; i <= prices.length ; i++){
            for(int j = 0 ; j < 3 ; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(prices, true, 0, 0, dp);
    }
}
