class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // Stair like comparison
        if (matrix.length == 0) return false;
        
        int m  = matrix.length; //row
        int n = matrix[0].length; // col
           
        int left = 0;
        int right = m * n - 1;
        
        while(left <= right) {
            
            int mid = left + (right - left)/2;
            
            //calculate row and col from mid
            int i = mid / n;
            int j = mid % n;
            
            int val = matrix[i][j];
            
            if (val == target) return true;
            else if (val < target) left = mid + 1;
            else right = mid - 1;
            
        }
        
        return false;
    }
}