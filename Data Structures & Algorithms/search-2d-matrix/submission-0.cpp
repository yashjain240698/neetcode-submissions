class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int l = 0 , r = matrix.size() * matrix[0].size() - 1;

        while(l <= r){
            int mid = (l + r)>>1;

            int row = mid/matrix[0].size();
            int col = mid%matrix[0].size();

            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }   
        }

        return false;
    }
};
