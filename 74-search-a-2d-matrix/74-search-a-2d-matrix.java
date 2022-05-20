class Solution {
    
    // Both rows and columns are sorted 
    // Start from the right corner
    public boolean searchMatrix(int[][] matrix, int target) {
        
      int m = matrix.length; // rows
      int n = matrix[0].length;  // cols
        
      int i = 0;
      int j = n-1;
        
      while(i >= 0 && i < m && j >= 0 && j < n) {
          
          int val = matrix[i][j];
          
          if (val == target) return true;
          else if (val > target) j--;
          else if (val < target) i++;
          
      }  
        
        return false;
    }
}