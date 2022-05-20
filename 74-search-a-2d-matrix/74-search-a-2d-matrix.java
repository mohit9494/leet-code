class Solution {  
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0) return false;
        
        int m = matrix.length; //row
        int n = matrix[0].length; //col
        
        // Consider it as a full sorted array witn length m * n - 1 
        // use binary search
            
        int left = 0;
        int right = m * n - 1 ;
        
        while (left <= right) {
            
            int mid = left + (right - left)/2;
            
            // convert it into row and cols
            int i = mid / n; // (n * m) / n
            int j = mid % n;
            
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return false;
    }
}