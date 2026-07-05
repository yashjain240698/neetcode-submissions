class Solution {
    private int dfs(int[][] matrix, int x, int y, int val, int[][] dp) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= val)
            return 0;

        if (dp[x][y] != -1)
            return dp[x][y];

        int p1 = dfs(matrix, x + 1, y, matrix[x][y], dp);
        int p2 = dfs(matrix, x - 1, y, matrix[x][y], dp);
        int p3 = dfs(matrix, x, y + 1, matrix[x][y], dp);
        int p4 = dfs(matrix, x, y - 1, matrix[x][y], dp);

        return dp[x][y] = Math.max(Math.max(p1, p2), Math.max(p3, p4)) + 1;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int l = matrix.length;
        int b = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[l + 1][b + 1];
        for (int i = 0; i <= l; i++) Arrays.fill(dp[i], -1);
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < b; j++) {
                ans = Math.max(dfs(matrix, i, j, -1, dp), ans);
            }
        }
        return ans;
    }
}
