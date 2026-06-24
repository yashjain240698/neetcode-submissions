class Solution {
    private Boolean isValid(int n, int[][] pos, int row, int col){
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(pos[row][i] == 1)
                cnt++;
        }
        for(int i = 0 ; i < n ; i++){
            if(pos[i][col] == 1)
                cnt++;
        }
        int tempRow = row, tempCol = col;
        while(tempRow >= 0 && tempCol >= 0){
            if(pos[tempRow][tempCol] == 1)
                cnt++;
            tempRow--;
            tempCol--;
        }

        tempRow = row; tempCol = col;
        while(tempRow >=0 && tempCol < n){
            if(pos[tempRow][tempCol] == 1)
                cnt++;
            tempRow--;
            tempCol++;
        }

        tempRow = row; tempCol = col;
        while(tempRow < n && tempCol >= 0){
            if(pos[tempRow][tempCol] == 1)
                cnt++;
            tempRow++;
            tempCol--;
        }

        tempRow = row; tempCol = col;
        while(tempRow <n && tempCol < n){
            if(pos[tempRow][tempCol] == 1)
                cnt++;
            tempRow++;
            tempCol++;
        }
        
        return cnt == 0;
    }
    private void helper(int n, int[][] pos, int row, List<List<String>> ans){
        if(row >= n){
            StringBuilder str = new StringBuilder();
            List<String> tmp = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                str = new StringBuilder();
                for(int j = 0 ; j < n ; j++){
                    if(pos[i][j] == 1){
                        str.append("Q");
                    } else {
                        str.append(".");
                    }
                }
                tmp.add(str.toString());
            }
            ans.add(tmp);
            System.out.println("row : " + row);
            return ;
        }

        for(int i = 0 ; i < n ; i++){
            
            if(isValid(n, pos, row, i)){
                pos[row][i] = 1;
                helper(n, pos, row+1, ans);
                pos[row][i] = 0;
            }

        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] pos = new int[n][n];
        helper(n, pos, 0, ans);
        return ans;
    }
}
