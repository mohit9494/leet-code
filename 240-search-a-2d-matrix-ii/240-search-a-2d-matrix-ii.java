class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // Use StairLike Comparison
        if (matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = n-1;
        
        while (i >= 0 && i < m && j>= 0 && j < n) {
            
         int val = matrix[i][j];   
        
         if (val == target) return true;
            else if (val < target) i++;
            else  if (val > target) j--;            
        }
        
        return false;
        
    }
}