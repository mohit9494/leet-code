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
        int[][] dp = new int[n][n];
        
        // Initialize
        for (int i = 0; i <= n - 1; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }
        
        // start with the second last row 
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= n - 1; j++) {
                // get the min
                int min = (int) 1e9;
                for (int k = -1; k <= 1; k++) {
                    if (j + k >= 0 && j + k <= n - 1) {
                       min = Math.min(min, dp[i + 1][j + k]); 
                    }
                }
                dp[i][j] = matrix[i][j] + min;
            }
        }
        return Arrays.stream(dp[0]).min().getAsInt();
    }
}