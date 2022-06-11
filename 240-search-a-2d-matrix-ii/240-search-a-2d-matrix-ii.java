class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        
        int i = 0, j = n - 1;
        int a = m - 1, b = 0;
        
        while (i < m && j >= 0 & a >= 0 && b < n) {
            
            int num = matrix[i][j];
            int num1 = matrix[a][b];
            
            if (num == target) return true;
            else if (num < target) i++;
            else j--;
            
            if (num1 == target) return true;
            else if (num1 < target) b++;
            else a--;
            
        }
        
        return false;
        
    }
}