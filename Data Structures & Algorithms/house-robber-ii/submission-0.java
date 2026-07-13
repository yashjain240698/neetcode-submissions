class Solution {
    private int helper(int[] nums, int idx, int r, int[] dp) {
        if (idx > r) {
            return 0;
        }

        if(dp[idx] != -1)
            return dp[idx];

        int ans = helper(nums, idx + 1, r, dp);

        ans = Math.max(ans, nums[idx] + helper(nums, idx + 2, r, dp));

        return dp[idx] = ans;
    }
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans1 = helper(nums, 0, nums.length - 2, dp);
        Arrays.fill(dp, -1);
        int ans2 = helper(nums, 1, nums.length - 1, dp);
        return Math.max(ans1,ans2);
    }
}
