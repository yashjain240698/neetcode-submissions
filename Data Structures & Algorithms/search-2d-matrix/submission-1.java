class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length * matrix[0].length-1;
        int len = matrix.length, bredth = matrix[0].length;
        while(l <= r){
            int mid = l + (r-l)/2;
            //System.out.println("l : " + l + " b : " + r + " mid : " + mid);
            if(matrix[mid/bredth][mid%bredth] == target){
                return true;
            } else if(matrix[mid/bredth][mid%bredth] < target){
                l = mid+1;
            } else {
                r = mid-1;
            }
        } 
        return false;
    }
}
