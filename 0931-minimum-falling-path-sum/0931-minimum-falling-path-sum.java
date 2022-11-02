class Solution {
    
    public int helper(int[][] arr, int i, int j, int[][] dp) {
        
        if (j < 0 || j > arr.length - 1) return (int)1e9;
        
        if (i < 0) return 0; 
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int a1 = arr[i][j] + helper(arr, i - 1, j, dp);
        int a2 = arr[i][j] + helper(arr, i - 1, j - 1, dp);
        int a3 = arr[i][j] + helper(arr, i - 1, j + 1, dp);
        
        return dp[i][j] = Math.min(a1, Math.min(a2, a3));
    }
    
    
    public int minFallingPathSum(int[][] matrix) {
     int n = matrix.length;
     // Start from all end points
     int min = (int) 1e9;
     int[][] dp = new int[n][n];
     for (int[] arr : dp) Arrays.fill(arr, -1);
     for (int j = 0; j <= n - 1; j++) {
         min = Math.min(min, helper(matrix, n - 1, j, dp));
     } 
     return min;
    }
}