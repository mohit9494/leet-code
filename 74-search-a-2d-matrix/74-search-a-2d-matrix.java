class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // Stair like comparison
        if (matrix.length == 0) return false;
        
        int m  = matrix.length; //row
        int n = matrix[0].length; // col
        
        int i = 0;
        int j = n-1;
           
        while(i >= 0 && i < m && j >= 0 && j < n) {
            
            int val = matrix[i][j];
            
            if(val == target) return true;
            else if (target < val) j--;
            else if (target > val) i++;            
            
        }
            
        return false;
        
    }
}