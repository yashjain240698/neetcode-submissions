class Solution {
    Set<String> ans = new HashSet<>();
    public void dfs(char[][] board, String word, int idx, int x, int y, int[][] vis) {
        if (idx >= word.length()) {
            ans.add(word);
            return;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || vis[x][y] == 1
            || word.charAt(idx) != board[x][y]) {
            return;
        }
        vis[x][y] = 1;
        dfs(board, word, idx + 1, x + 1, y, vis);
        dfs(board, word, idx + 1, x, y + 1, vis);
        dfs(board, word, idx + 1, x - 1, y, vis);
        dfs(board, word, idx + 1, x, y - 1, vis);
        vis[x][y] = 0;
    }
    public List<String> findWords(char[][] board, String[] words) {
        int len = words.length;
        int l = board.length;
        int b = board[0].length;
        int[][] vis = new int[l][b];
        for (int i = 0; i < len; i++) {
            char c = words[i].charAt(0);
            vis = new int[l][b];
            for (int j = 0; j < l; j++) {
                for (int k = 0; k < b; k++) {
                    if (board[j][k] == c) {
                        // vis[j][k] = 1;
                        dfs(board, words[i], 0, j, k, vis);
                        // vis[j][k] = 0;
                    }
                }
            }
        }
        return ans.stream().collect(Collectors.toList());
    }
}
