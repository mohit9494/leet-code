class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // This is Pure Binary Search
        int m = matrix.length;
        int n = matrix[0].length;
        
        int lo = 0;
        int hi = m * n - 1;
        
        while (lo <= hi) {
            
            int mid = lo + (hi - lo)/2;
            
            int element = matrix[mid / n][mid % n];
            
            if (element == target) return true;         
            else if (element < target) lo++;
            else hi--;
        }
      return false;  
    }
}