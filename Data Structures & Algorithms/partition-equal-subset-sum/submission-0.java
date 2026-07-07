class Solution {
    private boolean helper(int[] nums, int idx, int target, int[][] dp) {
        if (target < 0 || idx >= nums.length)
            return false;

        if (target == 0)
            return true;

        if (dp[idx][target] != -1) {
            return dp[idx][target] != 0;
        }

        boolean found = false;

        found = found || helper(nums, idx + 1, target, dp);

        found = found || helper(nums, idx + 1, target - nums[idx], dp);
        dp[idx][target] = (found == true) ? 1 : 0;

        return found;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i : nums) sum += i;
        if (sum % 2 == 1)
            return false;
        int[][] dp = new int[nums.length + 1][sum / 2 + 1];
        for (int i = 0; i <= nums.length; i++) Arrays.fill(dp[i], -1);
        return helper(nums, 0, sum / 2, dp);
    }
}
