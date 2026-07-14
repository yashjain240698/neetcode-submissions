class Solution {
    private int helper(String word1, String word2, int i, int j, int[][] dp) {
        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int value = 100000000;
        if (word1.charAt(i) == word2.charAt(j)) {
            value = helper(word1, word2, i - 1, j - 1, dp);
        } else {
            value = Math.min(helper(word1, word2, i - 1, j, dp),
                        Math.min(helper(word1, word2, i - 1, j - 1, dp),
                            helper(word1, word2, i, j - 1, dp)))
                + 1;
        }

        return dp[i][j] = value;
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }
}
